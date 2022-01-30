<template>
  <div class="wrapC">
    <div class="wrap-contact3">
      <h1>추가정보입력</h1>

      <div class="w-32 h-32 border-2 border-dotted border-blue-500">
        <div>
          <form
            align="left"
            class="filterbox1"
            method="post"
            enctype="multipart/form-data"
          >
            <div>
              <label for="chooseFile"> Click </label>
            </div>
            <input
              ref="image"
              @change="uploadImg()"
              type="file"
              id="chooseFile"
              name="chooseFile"
              accept="image/*"
            />
          </form>
          <img :src="image" alt="" class="" />
        </div>
      </div>
      <br />

      <div class="item-box">
        <div class="d-flex">
          <!-- 나이 입력 -->
          <div align="left" class="p-3">
            <h4>나이</h4>
            <select @change="age_select" v-model="user_age" class="form-select">
              <option disabled value="">나이 선택</option>
              <option value="10">10대</option>
              <option value="20">20대</option>
              <option value="30">30대</option>
              <option value="40">40대</option>
              <option value="50">50대</option>
              <option value="60">60대</option>
              <option value="70">70대</option>
              <option value="80">80대</option>
              <option value="90">90대</option>
            </select>
          </div>

          <!-- 지역 입력 -->
          <div align="left" class="p-3">
            <h4>거주 지역</h4>
            <select
              @change="area_select"
              v-model="user_area"
              class="form-select"
            >
              <option disabled value="">지역선택</option>
              <option value="서울">서울</option>
              <option value="부산">부산</option>
              <option value="대구">대구</option>
              <option value="인천">인천</option>
              <option value="광주">광주</option>
              <option value="대전">대전</option>
              <option value="울산">울산</option>
              <option value="세종">세종</option>
              <option value="경기">경기</option>
              <option value="강원">강원</option>
              <option value="충북">충북</option>
              <option value="충남">충남</option>
              <option value="전북">전북</option>
              <option value="전남">전남</option>
              <option value="경북">경북</option>
              <option value="경남">경남</option>
              <option value="제주">제주</option>
            </select>
          </div>
        </div>

        <!-- 성별 입력 -->
        <div>
          <div align="left"><h4>성별</h4></div>
          <div align="left">
            <button
              :class="{
                modifygenderButtonOn: maleButton,
                modifygenderButtonOff: !maleButton,
              }"
              @click="clickMale"
            >
              남자
            </button>
            <button
              :class="{
                modifygenderButtonOn: femaleButton,
                modifygenderButtonOff: !femaleButton,
              }"
              @click="clickFemale"
            >
              여자
            </button>
          </div>
        </div>
      </div>

      <!-- 아이템선택 -->
      <div class="mt-3">
        <Items @img-status="imgStatus" />
      </div>
      <div class="item-box mt-3">
        <div align="left">
          <h4>기타 장비</h4>
        </div>
        <EquipInput />
        <EquipList />
      </div>
      <div class="item-box mt-3">
        <style_Dropdown />
      </div>
      <br />
      <button class="btn-success">제출완료</button>
    </div>
  </div>
</template>

<script>
import Items from "@/components/user/Items.vue";
import EquipInput from "@/components/user/equip_input.vue";
import EquipList from "@/components/user/equip_list.vue";
// import area_Dropdown from '../../components/user/area_Dropdown.vue'
// import age_Dropdown from '../../components/user/age_Dropdown.vue'
import style_Dropdown from "../../components/user/campstyle.vue";

export default {
  name: "addSign",
  components: {
    Items,
    EquipInput,
    EquipList,
    // area_Dropdown,
    // age_Dropdown,
    style_Dropdown,
  },
  data: function () {
    return {
      myProfileInfos: {
        image: "",
        maleButton: false,
        femaleButton: false,
        user_gender: false,
        user_age: "",
        user_area: "",
        credentials: {
          equip: [],
          any_equip: [],
        },
        error: {
          user_gender: false,
        },
      },
    };
  },
  methods: {
    uploadImg() {
      console.log("들어왔다");
      var image = this.$refs["image"].files[0];

      const url = URL.createObjectURL(image);
      this.image = url;
      console.log(url);
      console.log(this.image);
    },

    checkGender() {
      if (!this.user_gender) {
        this.error.user_gender = "성별을 선택해주세요";
        this.buttonShow = false;
      } else {
        this.error.user_gender = false;
      }
    },
    age_select() {
      console.log(this.user_age);
    },

    area_select() {
      console.log(this.user_area);
    },

    imgStatus(text) {
      console.log(text);
    },

    clickFemale: function () {
      this.femaleButton = true;
      this.maleButton = false;
      this.user_gender = "W";
      console.log(this.user_gender);
    },

    clickMale: function () {
      this.maleButton = true;
      this.femaleButton = false;
      this.user_gender = "M";
      console.log(this.user_gender);
    },
  },
};
</script>

<style scoped>
.body-form {
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
  /* background: beige; */
}

.wrapC {
  display: flex;
  width: 100%;
  flex-direction: column;
  background-color: white;
  align-items: center;
  justify-content: top;
  padding: 0 4vw;
  min-height: 100vh;
}

.wrap-contact3 {
  width: 768px;
  border-radius: 10px;
  overflow: hidden;
  padding: 72px 55px 65px 55px;
  background: white;
}

body {
  text-align: center;
  background-color: #f6f6f6;
}

.wrap-input3 {
  margin-top: 10px;
  width: 80%;
  position: relative;
  border-bottom: 2px solid #000000;
  border-top: 2px solid #f3a90800;
  margin-bottom: 27px;
}

.item-box {
  border-style: solid;
  border-color: rgb(204, 123, 123);
  border-radius: 45px;
  padding: 20px;
  width: 100%;
}

.filterbox1 {
  float: left;
  margin-left: 50px;
  margin-right: 20px;
}
.filterbox2 {
  /* float: left; */
}

.modifygenderButtonOn {
  width: 40%;
  margin: 0 1vw;
  margin-top: 2vh;
  background-color: skyblue;
  color: white;
  border: 0.3vw solid;
  border-color: skyblue;
  font-weight: bold;
  font-size: 2vw;
  padding: 0.5vw;
  border-radius: 1vw;
  transition-duration: 0.5s;
}
.modifygenderButtonOff {
  width: 40%;
  margin: 0 1vw;
  margin-top: 2vh;
  background-color: white;
  color: mediumslateblue;
  border: 0.3vw solid;
  border-color: mediumslateblue;
  font-weight: bold;
  font-size: 2vw;
  padding: 0.5vw;
  border-radius: 1vw;
  transition-duration: 0.5s;
}
</style>
