<template>
  <div>
    <form>
      <div v-if="step === 1">
        <div class="wrapC">
          <div class="wrap-contact3">
            <h1 class="contact3-form-title">정보 수정</h1>

            <!-- 닉네임 입력 -->
            <div class="nickname-container mt-2">
              <h6 align="left">닉네임</h6>
              <div class="form-group">
                <b-form-input
                  type="text"
                  style="width: 50%; float: left"
                  placeholder="닉네임을 입력하세요"
                  v-model="exam_user"
                  autofocus
                >
                </b-form-input>
                <b-button>중복확인</b-button>
              </div>
            </div>

            <!-- 비밀번호 -->
            <div class="password-container mt-2">
              <h6 align="left">비밀번호</h6>
              <div class="form-group">
                <b-form-input
                  type="password"
                  style="width: 50%; float: left"
                  placeholder="비밀번호를 입력하세요"
                  v-model="credentials.userPassword"
                  autofocus
                >
                </b-form-input>
              </div>
            </div>

            <!-- 비밀번호 확인 -->
            <div class="passwordconfirm-container mt-3">
              <h6 align="left">비밀번호확인</h6>
              <div class="form-group">
                <b-form-input
                  type="password"
                  style="width: 50%; float: left"
                  placeholder="비밀번호를 한번 더 입력하세요"
                  v-model="credentials.password_confirmation"
                  autofocus
                >
                </b-form-input>
              </div>
            </div>

            <!--  약관동의 -->
            <div class="form-group mt-3" align="left">
              <input type="checkbox" id="term" />
              <span>약관을 동의합니다.</span>
              <!-- <span>약관보기</span> -->
            </div>

            <!-- 다음 버튼 -->
            <button class="mt-5" @click.prevent="next()">Next</button>
          </div>
        </div>
      </div>

      <!-- 2페이지 -->
      <div v-if="step === 2">
        <div class="wrapC">
          <div class="wrap-contact3">
            <h1 class="contact3-form-title">추가 정보</h1>

            <div class="item-box">
              <div class="d-flex">
                <!-- 나이 입력 -->
                <div align="left" class="p-3">
                  <h4>나이</h4>
                  <select
                    @change="age_select"
                    v-model="credentials.userAge"
                    class="form-select"
                  >
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
                    v-model="credentials.userLocation"
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
                    type="button"
                    :class="{
                      modifygenderButtonOn: maleButton,
                      modifygenderButtonOff: !maleButton,
                    }"
                    @click="clickMale"
                  >
                    남자
                  </button>
                  <button
                    type="button"
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

            <!-- 이미지 -->
            <Fileupload @image="uploadedImage" />

            <div class="d-flex justify-content-between mt-5">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>
        </div>
      </div>

      <div v-if="step === 3">
        <div class="wrapC">
          <div class="wrap-contact3">
            <h1 class="contact3-form-title">Camp Style</h1>

            <div class="item-box2 mt-3">
              <CampStyle2
                @style-status="styleStatus"
                :campStyle1="this.credentials.campStyle1"
                :campStyle2="this.credentials.campStyle2"
                :campStyle3="this.credentials.campStyle3"
                :campStyle4="this.credentials.campStyle4"
                :campStyle5="this.credentials.campStyle5"
                :campStyle6="this.credentials.campStyle6"
              />
            </div>
            <div class="mt-3">
              <Items2
                :campEquipLantern="this.credentials.campEquipLantern"
                :campEquipReel="this.credentials.campEquipReel"
                :campEquipBurner="this.credentials.campEquipBurner"
                :campEquipicebox="this.credentials.campEquipicebox"
                :campEquipTableChair="this.credentials.campEquipTableChair"
                :campEquipSleepingbag="this.credentials.campEquipSleepingbag"
                :table="this.credentials.table"
                :campEquipTent="this.credentials.campEquipTent"
                :campEquipBrazier="this.credentials.campEquipBrazier"
                :campEquipTarp="this.credentials.campEquipTarp"
                @img-status="imgStatus"
              />
            </div>
            <div class="item-box mt-3">
              <div align="left">
                <h4>기타 장비</h4>
              </div>
              <EquipInput />
              <EquipList />
            </div>

            <div class="d-flex justify-content-between mt-5">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="onSubmit()">Save</button>
            </div>
          </div>
        </div>
      </div>

      <div class="filterbox">
        <button
          type="button"
          class="btn btn-secondary launch filterbox1 col-xs-4"
          data-bs-toggle="modal"
          data-bs-target="#staticBackdrop"
        >
          회원탈퇴
        </button>
        <div
          class="modal fade"
          id="staticBackdrop"
          data-backdrop="static"
          data-keyboard="false"
          tabindex="-1"
          aria-labelledby="staticBackdropLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-body">
                <Modal :myEmail="this.myEmail" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
    <button class="btn-danger" @click="deleteAccount">
      정말 떠나시나요...?
    </button>
    <br /><br />Debug: {{ credentials }}
  </div>
</template>

<script>
import axios from "axios";
import Items2 from "@/components/user/Items2.vue";
import CampStyle2 from "@/components/user/campstyle2.vue";
import EquipInput from "@/components/user/equip_input.vue";
import EquipList from "@/components/user/equip_list.vue";
import Fileupload from "@/components/mateparty/Fileupload.vue";
import Modal from "@/components/user/Modal.vue";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "ModifyUser",
  components: {
    Items2,
    CampStyle2,
    EquipInput,
    EquipList,
    Fileupload,
    Modal,
  },

  data() {
    return {
      step: 1,
      myId: this.$store.state.myNum, // 로그인한 유저넘버
      myEmail: this.$store.state.userEmail, // 로그인한 유저이메일
      exam_user: "dohun",
      credentials: {
        userEmail: "", // 이메일
        userNickname: "", // 닉네임
        userPassword: "", // 패스워드
        userName: "",
        password_confirmation: "", // 패스워드확인
        userGender: "", // 성별
        userLocation: "", // 지역
        userAge: "", // 나이
        userMBTI: "",
        campEquipLantern: 0,
        campEquipReel: 0,
        campEquipBurner: 0,
        campEquipicebox: 0,
        campEquipTableChair: 0,
        campEquipSleepingbag: 0,
        campEquipTarp: 0,
        table: 0,
        campEquipTent: 0,
        campEquipBrazier: 0,
        campStyle1: 0,
        campStyle2: 0,
        campStyle3: 0,
        campStyle4: 0,
        campStyle5: 0,
        campStyle6: 0,
        userProfileImage: "",
        // 보유장비
        imgStatus: {
          campEquipLantern: 0,
          campEquipReel: 0,
          campEquipBurner: 0,
          campEquipicebox: 0,
          campEquipTableChair: 0,
          campEquipSleepingbag: 0,
          campEquipTarp: 0,
          table: 0,
          campEquipTent: 0,
          campEquipBrazier: 0,
        },
        styleStatus: {
          campStyle1: 0,
          campStyle2: 0,
          campStyle3: 0,
          campStyle4: 0,
          campStyle5: 0,
          campStyle6: 0,
        },
      },
      maleButton: false,
      femaleButton: false,
    };
  },

  created: function () {
    console.log(this.myEmail);
    this.getProfile();
  },
  methods: {
    prev() {
      this.step--;
    },
    next() {
      this.step++;
    },
    getProfile: function () {
      axios
        .get(`${SERVER_URL}/user/${this.myEmail}`)
        .then((res) => {
          console.log(res);
          this.credentials.userEmail = res.data.email;
          this.credentials.userNickname = res.data.nickname;
          this.credentials.userPassword = res.data.userPassword;
          this.credentials.userName = res.data.userName;
          this.credentials.password_confirmation = res.data.userPassword;
          this.credentials.userGender = res.data.userGender;
          this.credentials.userLocation = res.data.userLocation;
          this.credentials.userAge = res.data.userAge;
          this.credentials.userMBTI = res.data.userMBTI;
          this.credentials.campEquipLantern = res.data.campEquipLantern;
          this.credentials.campEquipReel = res.data.campEquipReel;
          this.credentials.campEquipBurner = res.data.campEquipBurner;
          this.credentials.campEquipicebox = res.data.campEquipicebox;
          this.credentials.campEquipTableChair = res.data.campEquipTableChair;
          this.credentials.campEquipSleepingbag = res.data.campEquipSleepingbag;
          this.credentials.campEquipTarp = res.data.campEquipTarp;
          this.credentials.table = res.data.table;
          this.credentials.campEquipTent = res.data.campEquipTent;
          this.credentials.campEquipBrazier = res.data.campEquipBrazier;
          this.credentials.campStyle1 = res.data.campStyle1;
          this.credentials.campStyle2 = res.data.campStyle2;
          this.credentials.campStyle3 = res.data.campStyle3;
          this.credentials.campStyle4 = res.data.campStyle4;
          this.credentials.campStyle5 = res.data.campStyle5;
          this.credentials.campStyle6 = res.data.campStyle6;
          this.credentials.userProfileImage = res.data.userProfileImage;

          if (this.credentials.userGender == "W") {
            this.femaleButton = true;
          } else if (this.credentials.userGender == "M") {
            this.maleButton = true;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteAccount: function () {
      console.log(1);
      console.log("여기", this.myEmail);
      axios
        .delete(`${SERVER_URL}/user/${this.myEmail}`)
        .then(() => {
          alert("함께할 시간을 기다리겠습니다.");
          this.logout();
          this.$router.push({ name: "Mainpage" });
        })
        .catch(() => {
          alert("잠시 후 다시 시도해주세요.");
        });
    },
    logout: function () {
      this.$store.state.user = null;
      this.$store.state.userEmail = null;
      this.$store.dispatch("logout");
      sessionStorage.removeItem("userList");
      sessionStorage.removeItem("myNum");
      sessionStorage.removeItem("userEmail");
      sessionStorage.removeItem("userPassword");
    },

    clickFemale: function () {
      this.femaleButton = true;
      this.maleButton = false;
      this.credentials.userGender = "W";
      console.log(this.credentials.userGender);
    },

    clickMale: function () {
      this.maleButton = true;
      this.femaleButton = false;
      this.credentials.userGender = "M";
      console.log(this.credentials.userGender);
    },
    uploadedImage(file) {
      this.userProfileImage = file;
      console.log(this.userProfileImage);
    },

    imgStatus(text) {
      if (text.campEquipLantern === 1) {
        this.credentials.imgStatus.campEquipLantern = 1;
        this.credentials.campEquipLantern = 1;
      } else {
        this.credentials.imgStatus.campEquipLantern = 0;
        this.credentials.campEquipLantern = 0;
      }
      if (text.campEquipReel === 1) {
        this.credentials.imgStatus.campEquipReel = 1;
        this.credentials.campEquipReel = 1;
      } else {
        this.credentials.imgStatus.campEquipReel = 0;
        this.credentials.campEquipReel = 0;
      }
      if (text.campEquipBurner === 1) {
        this.credentials.imgStatus.campEquipBurner = 1;
        this.credentials.campEquipBurner = 1;
      } else {
        this.credentials.imgStatus.campEquipBurner = 0;
        this.credentials.campEquipBurner = 0;
      }
      if (text.campEquipicebox === 1) {
        this.credentials.imgStatus.campEquipicebox = 1;
        this.credentials.campEquipicebox = 1;
      } else {
        this.credentials.imgStatus.campEquipicebox = 0;
        this.credentials.campEquipicebox = 0;
      }
      if (text.campEquipTableChair === 1) {
        this.credentials.imgStatus.campEquipTableChair = 1;
        this.credentials.campEquipTableChair = 1;
      } else {
        this.credentials.imgStatus.campEquipTableChair = 0;
        this.credentials.campEquipTableChair = 0;
      }
      if (text.campEquipSleepingbag === 1) {
        this.credentials.imgStatus.campEquipSleepingbag = 1;
        this.credentials.campEquipSleepingbag = 1;
      } else {
        this.credentials.imgStatus.campEquipSleepingbag = 0;
        this.credentials.campEquipSleepingbag = 0;
      }
      if (text.campEquipTarp === 1) {
        this.credentials.imgStatus.campEquipTarp = 1;
        this.credentials.campEquipTarp = 1;
      } else {
        this.credentials.imgStatus.campEquipTarp = 0;
        this.credentials.campEquipTarp = 0;
      }
      if (text.table === 1) {
        this.credentials.imgStatus.table = 1;
        this.credentials.table = 1;
      } else {
        this.credentials.imgStatus.table = 0;
        this.credentials.table = 0;
      }
      if (text.campEquipTent === 1) {
        this.credentials.imgStatus.campEquipTent = 1;
        this.credentials.campEquipTent = 1;
      } else {
        this.credentials.imgStatus.campEquipTent = 0;
        this.credentials.campEquipTent = 0;
      }
      if (text.campEquipBrazier === 1) {
        this.credentials.imgStatus.campEquipBrazier = 1;
        this.credentials.campEquipBrazier = 1;
      } else {
        this.credentials.imgStatus.campEquipBrazier = 0;
        this.credentials.campEquipBrazier = 0;
      }
    },
    styleStatus(text) {
      if (text.campStyle1 === 1) {
        this.credentials.styleStatus.campStyle1 = "Y";
        this.credentials.campStyle1 = "Y";
      } else {
        this.credentials.styleStatus.campStyle1 = "N";
        this.credentials.campStyle1 = "N";
      }

      if (text.campStyle2 === 1) {
        this.credentials.styleStatus.campStyle2 = "Y";
        this.credentials.campStyle2 = "Y";
      } else {
        this.credentials.styleStatus.campStyle2 = "N";
        this.credentials.campStyle2 = "N";
      }

      if (text.campStyle3 === 1) {
        this.credentials.styleStatus.campStyle3 = "Y";
        this.credentials.campStyle3 = "Y";
      } else {
        this.credentials.styleStatus.campStyle3 = "N";
        this.credentials.campStyle3 = "N";
      }

      if (text.campStyle4 === 1) {
        this.credentials.styleStatus.campStyle4 = "Y";
        this.credentials.campStyle4 = "Y";
      } else {
        this.credentials.styleStatus.campStyle4 = "N";
        this.credentials.campStyle4 = "N";
      }

      if (text.campStyle5 === 1) {
        this.credentials.styleStatus.campStyle5 = "Y";
        this.credentials.campStyle5 = "Y";
      } else {
        this.credentials.styleStatus.campStyle5 = "N";
        this.credentials.campStyle5 = "N";
      }

      if (text.campStyle6 === 1) {
        this.credentials.styleStatus.campStyle6 = "Y";
        this.credentials.campStyle6 = "Y";
      } else {
        this.credentials.styleStatus.campStyle6 = "N";
        this.credentials.campStyle6 = "N";
      }
    },
  },
};
</script>

<style></style>
