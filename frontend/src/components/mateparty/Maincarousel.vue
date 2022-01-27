<template>
  <body>
  <!-- <div class="container" style="margin-top:50px;"> -->
    <div class="row " style="padding: 0 20px;" align="center">
      <div class="col-md">
          <div class="card-sl">
              <div class="card-image">
                <img src='https://picsum.photos/id/973/200/300' height="100%" width="100%" />
              </div>
              <div class="card-heading" align="left">
                  불멍 매니아들 모여라! 싫으면 말고! 아니면 좋고 되면 더좋고! 싫으면 냉면!
              </div>
              <div class="card-text" align="left">
                  가평 포레스트 펜션<i class="bi bi-person-fill" style="float:right">2/4</i>
              </div>
          </div>
      </div>
      <div class="col-md">
          <div class="card-sl">
              <div class="card-image">
                <img src='https://picsum.photos/id/973/200/300' height="100%" width="100%" />
              </div>
              <div class="card-heading" align="left">
                  불멍 매니아들 모여라! 싫으면 말고! 아니면 좋고 되면 더좋고! 싫으면 냉면!
              </div>
              <div class="card-text" align="left">
                  가평 포레스트 펜션<i class="bi bi-person-fill" style="float:right">2/4</i>
              </div>
          </div>
      </div>
      <div class="col-md">
          <div class="card-sl">
              <div class="card-image">
                <img src='https://picsum.photos/id/973/200/300' height="100%" width="100%" />
              </div>
              <div class="card-heading" align="left">
                  불멍 매니아들 모여라! 싫으면 말고! 아니면 좋고 되면 더좋고! 싫으면 냉면!
              </div>
              <div class="card-text" align="left">
                  가평 포레스트 펜션<i class="bi bi-person-fill" style="float:right">2/4</i>
              </div>
          </div>
      </div>
      <div class="col-md">
          <div class="card-sl">
              <div class="card-image">
                <img src='https://picsum.photos/id/973/200/300' height="100%" width="100%" />
              </div>
              <div class="card-heading" align="left">
                  불멍 매니아들 모여라! 싫으면 말고! 아니면 좋고 되면 더좋고! 싫으면 냉면!
              </div>
              <div class="card-text" align="left">
                  가평 포레스트 펜션<i class="bi bi-person-fill" style="float:right">2/4</i>
              </div>
          </div>
      </div>
      <div class="col-md">
          <div class="card-sl">
              <div class="card-image">
                <img src='https://picsum.photos/id/973/200/300' height="100%" width="100%" />
              </div>
              <div class="card-heading" align="left">
                  불멍 매니아들 모여라df! 싫으면 말고! 아니면 좋고 되면 더좋고! 싫으면 냉면!
              </div>
              <div class="card-text" align="left">
                  가평 포레스트 펜션<i class="bi bi-person-fill" style="float:right">2/4</i>
              </div>
          </div>
      </div>
    </div>
  <!-- </div> -->
  <div align="left" style="margin-top:40px; width:100%"  class="footer">
      <div style="padding:20px;">
        <h5 style="font-weight:bold">고객센터</h5>
        <br>
        <p>이메일 : tg8685@gmail.com</p>
        <p>전화번호 : 010-4449-8685</p>
        <p>업무시간 : 연중 무휴 24시간</p>
        <hr>
        <p>CAMPUS | 팀 번호 : E102</p>
        <p>대표 : 조해성 | 정보 관리 책임자 : 최호준</p>
        <p>부산시 연제구 유림아시아드 아파트</p>
        <p>CAMPUS는 거래당사자가 아니며, 호스트가 등록한 만남에 대한 일체의 책임을 지지 않습니다.</p>
      </div>
    </div>
  </body>
</template>

<script>
const items = [
          { id: 1, first_name: 'Fred', last_name: 'Flintstone', imgurl: 'https://picsum.photos/id/973/200/300' },
          { id: 2, first_name: 'Wilma', last_name: 'Flintstone', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 3, first_name: 'Barney', last_name: 'Rubble', imgurl: 'https://picsum.photos/id/973/200/300'  },
          { id: 4, first_name: 'Betty', last_name: 'Rubble', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 5, first_name: 'Pebbles', last_name: 'Flintstone', imgurl: 'https://picsum.photos/id/973/200/300'  },
          { id: 6, first_name: 'Bamm Bamm', last_name: 'Rubble', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 7, first_name: 'The Great', last_name: 'Gazzoo', imgurl: 'https://picsum.photos/id/973/200/300'  },
          { id: 8, first_name: 'Rockhead', last_name: 'Slate', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 9, first_name: 'Pearl', last_name: 'Slaghoople', imgurl: 'https://picsum.photos/id/973/200/300'  }
        ]
export default {
  name : 'Maincarousel',
  data() {
    return {
      items : items
    }
  }

}


</script>

<style  scoped>
body {
      font-family: Varela Round;
      overflow: hidden;
      width: 100%;
      height: auto;
      margin: 0 auto;
      
      /* background: beige; */
    }

    a {
        text-decoration: none;
    }

    /* Card Styles */

    .card-sl {
        border-radius: 8px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        width: 80%;
        
    }

    .card-image img {
        max-height: 190px;
        max-width: 100%;
        border-radius: 8px 8px 0px 0;
    }

    .card-action {
        position: relative;
        float: right;
        margin-top: -25px;
        margin-right: 20px;
        z-index: 2;
        color: #E26D5C;
        background: #fff;
        border-radius: 100%;
        padding: 15px;
        font-size: 15px;
        box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.2), 0 1px 2px 0 rgba(0, 0, 0, 0.19);
    }

    .card-action:hover {
        color: #fff;
        background: #E26D5C;
        -webkit-animation: pulse 1.5s infinite;
    }

    .card-heading {
        padding: 10px 15px;
        font-size: 18px;
        font-weight: bold;
        background: #fff;
        display:-webkit-box;
    -webkit-line-clamp:2;
    -webkit-box-orient:vertical;
    width:100%;
    height:50px;
    line-height:20px;
    overflow:hidden;
    text-overflow:ellipsis;
    }

    .card-text {
        padding: 10px 15px;
        background: #fff;
        font-size: 14px;
        color: #636262;
    }

    .card-button {
        display: flex;
        justify-content: center;
        padding: 10px 0;
        width: 100%;
        background-color: #1F487E;
        color: #fff;
        border-radius: 0 0 8px 8px;
    }

    .card-button:hover {
        text-decoration: none;
        background-color: #1D3461;
        color: #fff;

    }


    @-webkit-keyframes pulse {
        0% {
            -moz-transform: scale(0.9);
            -ms-transform: scale(0.9);
            -webkit-transform: scale(0.9);
            transform: scale(0.9);
        }

        70% {
            -moz-transform: scale(1);
            -ms-transform: scale(1);
            -webkit-transform: scale(1);
            transform: scale(1);
            box-shadow: 0 0 0 50px rgba(90, 153, 212, 0);
        }

        100% {
            -moz-transform: scale(0.9);
            -ms-transform: scale(0.9);
            -webkit-transform: scale(0.9);
            transform: scale(0.9);
            box-shadow: 0 0 0 0 rgba(90, 153, 212, 0);
        }
    }

     
.footer{
  background-color: rgb(231, 231, 231);
  
}
</style>