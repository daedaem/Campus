<template>
  <div>
    <div id="map" class="map"></div>
    <p style="margin-top:-120px">
    <em class="link">
        <a href="/web/documentation/#CategoryCode" target="_blank">카테고리 코드목록을 보시려면 여기를 클릭하세요!</a>
    </em>
</p>
<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
    <ul id="category">
        <li id="AT4" data-order="0" @click="onClickCategory('AT4')"> 
            <span class="category_bg attractive_area"></span>
            관광지
        </li>       
        <li id="MT1" data-order="1" @click="onClickCategory('MT1')"> 
            <span class="category_bg mart"></span>
            마트
        </li>  
        <li id="PM9" data-order="2" @click="onClickCategory('PM9')"> 
            <span class="category_bg pharmacy"></span>
            약국
        </li>  
        <li id="OL7" data-order="3" @click="onClickCategory('OL7')"> 
            <span class="category_bg oil"></span>
            주유소
        </li>  
        <li id="CE7" data-order="4" @click="onClickCategory('CE7')"> 
            <span class="category_bg cafe"></span>
            카페
        </li>  
        <li id="CS2" data-order="5" @click="onClickCategory('CS2')"> 
            <span class="category_bg store"></span>
            편의점
        </li>  
        <li id="FD6" data-order="6" @click="onClickCategory('FD6')"> 
            <span class="category_bg restaurant"></span>
            음식점
        </li>      
    </ul>
</div>
  </div>
</template>

<script>
export default {
  name : 'Kakaomap',
  props : ['detailData'],
  data() {
    return {
      map : null,
      markerPosition : null,
      marker : null,
      //카테고리
      ps : null,
      currCategory : null,
      markers : [],
      placeOverlay : null,
      contentNode : null,
      mapX : this.detailData.mapX,
      mapY : this.detailData.mapY,
    }
  },
  created() {
    
  },
  mounted() {
    console.log(this.mapX,this.mapY)
  
    window.kakao && window.kakao.maps
      ? this.initMap()
      : this.addKakaoMapScript();
      
  },
  methods: {
    initMap() {
      
      var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      var options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(this.mapY, this.mapX),
         //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
      };
      this.map = new kakao.maps.Map(container, options);
      this.markerPosition = new kakao.maps.LatLng(this.mapY, this.mapX);
      

      console.log(this.markerPosition)
      var marker = new kakao.maps.Marker({position: this.markerPosition});
      marker.setMap(this.map);

      //카테고리
      this.contentNode = document.createElement('div')
      this.placeOverlay = new kakao.maps.CustomOverlay({zIndex:1})
      //장소 객체 반환
      this.ps = new kakao.maps.services.Places(this.map); 
      kakao.maps.event.addListener(this.map, 'idle', this.searchPlaces);
      this.contentNode.className = 'placeinfo_wrap';
      this.addEventHandle(this.contentNode, 'mousedown', kakao.maps.event.preventMap);
      this.addEventHandle(this.contentNode, 'touchstart', kakao.maps.event.preventMap);
      this.placeOverlay.setContent(this.contentNode); 
      // this.addCategoryClickEvent();
      
    },

    addKakaoMapScript() {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=775711a8d98a369b66a1b25f847e2879";
      document.head.appendChild(script);
    },

    addEventHandle(target, type, callback) {
      if (target.addEventListener) {
          target.addEventListener(type, callback);
      } else {
          target.attachEvent('on' + type, callback);
      }
    },




    // 지도 위에 표시되고 있는 마커를 모두 제거합니다
    removeMarker() {
        for ( var i = 0; i < this.markers.length; i++ ) {
            this.markers[i].setMap(null);
        }   
        this.markers = [];
    },


    // 카테고리 검색을 요청하는 함수입니다
    searchPlaces() {
      if (!this.currCategory) {
          return;
      }
      
      // 커스텀 오버레이를 숨깁니다 
      this.placeOverlay.setMap(null);

      // 지도에 표시되고 있는 마커를 제거합니다
      this.removeMarker();
      console.log(this.currCategory)
      this.ps.categorySearch(this.currCategory, this.placesSearchCB, {useMapBounds:true}); 
    },

    // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
    placesSearchCB(data, status, ) {
      if (status === kakao.maps.services.Status.OK) {

          // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
          this.displayPlaces(data);
      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
          // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요

      } else if (status === kakao.maps.services.Status.ERROR) {
          // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
          
      }
    },

    // 지도에 마커를 표출하는 함수입니다
    displayPlaces(places) {

      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      var order = document.getElementById(this.currCategory).getAttribute('data-order');

      

      for ( var i=0; i<places.length; i++ ) {

              // 마커를 생성하고 지도에 표시합니다
              var marker = this.addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);

              // 마커와 검색결과 항목을 클릭 했을 때
              // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
              var $this = this;
              (function(marker, place) {
                  kakao.maps.event.addListener(marker, 'click', function() {
                      $this.displayPlaceInfo(place);
                  });
              })(marker, places[i]);
      }
    },

    // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
    addMarker(position, order) {
      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
          imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
          imgOptions =  {
              spriteSize : new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
              spriteOrigin : new kakao.maps.Point(46, (order*36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
              offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
          },
          markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
              marker = new kakao.maps.Marker({
              position: position, // 마커의 위치
              image: markerImage 
          });

      marker.setMap(this.map); // 지도 위에 마커를 표출합니다
      this.markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
    },

    // 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
    displayPlaceInfo (place) {
      console.log('들어는옴')
    var content = '<div class="placeinfo">' +
                    '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';   

    if (place.road_address_name) {
        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
    }  else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
    }                
   
    content += '    <span class="tel">' + place.phone + '</span>' + 
                '</div>' + 
                '<div class="after"></div>';

    this.contentNode.innerHTML = content;
    this.placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    this.placeOverlay.setMap(this.map);  
    },

    // 각 카테고리에 클릭 이벤트를 등록합니다
    // addCategoryClickEvent() {
    //   var category = document.getElementById('category')
    //   var children = category.children;
    //   console.log(category)
    //   console.log(children)
    //   for (var i=0; i<children.length; i++) {
    //       children[i].onclick = this.onClickCategory();
    //   }
    // },

    // 카테고리를 클릭했을 때 호출되는 함수입니다
    onClickCategory(itemId) {
      var id = itemId
      var className = this.className;
      this.placeOverlay.setMap(null);
      console.log(id)
      console.log(className)
      if (className === 'on') {
          console.log('온 인상태인데;')
          this.currCategory = id;
          this.changeCategoryClass();
          this.removeMarker();
          this.searchPlaces();
      } else {
          console.log('오프임')
          this.currCategory = id;
          console.log(this.currCategory)
          this.changeCategoryClass(this);
          this.searchPlaces();
      }
    },

    // 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
    changeCategoryClass(el) {
      var category = document.getElementById('category'),
          children = category.children,
          i;

      for ( i=0; i<children.length; i++ ) {
          children[i].className = '';
      }

      if (el) {
          el.className = 'on';
          
      } 
    } 

    
    
  }
};
</script>

<style>
.map {
  width: 100%;
  height: 400px;
}

.map_wrap, .map_wrap * {margin:0; padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap {position:relative;width:100%;height:350px;}
#category {position:absolute;top:10px;left:10px;border-radius: 5px; border:1px solid #909090;box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);background: #fff;overflow: hidden;z-index: 2;}
#category li {float:left;list-style: none;width:50px;border-right:1px solid #acacac;padding:6px 0;text-align: center; cursor: pointer;}
#category li.on {background: #eee;}
#category li:hover {background: #ffe6e6;border-left:1px solid #acacac;margin-left: -1px;}
#category li:last-child{margin-right:0;border-right:0;}
#category li span {display: block;margin:0 auto 3px;width:27px;height: 28px;}
#category li .category_bg {background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png) no-repeat;}
#category li .bank {background-position: -10px 0;}
#category li .mart {background-position: -10px -36px;}
#category li .pharmacy {background-position: -10px -72px;}
#category li .oil {background-position: -10px -108px;}
#category li .cafe {background-position: -10px -144px;}
#category li .store {background-position: -10px -180px;}
#category li.on .category_bg {background-position-x:-46px;}
.placeinfo_wrap {position:absolute;bottom:28px;left:-150px;width:300px;}
.placeinfo {position:relative;width:100%;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;padding-bottom: 10px;background: #fff;}
.placeinfo:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.placeinfo_wrap .after {content:'';position:relative;margin-left:-12px;left:50%;width:22px;height:12px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.placeinfo a, .placeinfo a:hover, .placeinfo a:active{color:#fff;text-decoration: none;}
.placeinfo a, .placeinfo span {display: block;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
.placeinfo span {margin:5px 5px 0 5px;cursor: default;font-size:13px;}
.placeinfo .title {font-weight: bold; font-size:14px;border-radius: 6px 6px 0 0;margin: -1px -1px 0 -1px;padding:10px; color: #fff;background: #d95050;background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.placeinfo .tel {color:#0f7833;}
.placeinfo .jibun {color:#999;font-size:11px;margin-top:0;}
</style>