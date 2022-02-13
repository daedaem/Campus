<template>
  <div class="test row" >
    <body class="col-12">
      
      <div class="registration-form">
        <form>
          
            <div class="">
              
              <Fileupload @image="uploadedImage" align="left"/>
           
            </div>
            <div class="form-group" style="margin-top:100px;">
              <h4>메이트 제목</h4>
                <input type="text" class="form-control item" id="username" placeholder="제목을 입력하세요.." v-model="partyData.mateTitle">
            </div>
            <div class="form-group">
              <h4>내용</h4>
                <textarea
                v-model="partyData.mateContent"
                name="txtMsg"
                class="form-control item"
                placeholder="Your Message *"
                style="width: 100%; height: 150px"
              ></textarea>
            </div>
            <div class="form-group"  >
              <h4>나이&인원 제한</h4>
                <Dropdown1 @member-value="memberValue" class="members"/>
                <Dropdown2 @age-value1="ageValue1" @age-value2="ageValue2" class="ages" style="display:inline;"/>
            </div>
            <div class="form-group" style="margin-top:20px;">
              <h4>캠핑장 선택</h4>
                <Campchoice
          align="left"
          style=" margin-bottom: 20px"
          @camp-data="campValue"
        />
            </div>
            <div class="form-group">
              <h4>날짜 선택</h4>
                <Datepicker @date-in="dateIn" class="date"/>
            </div>
            <div class="form-group" style="margin-top:50px;">
              <Filtermake
                @style-check="styleCheck"
                @limit-check="limitCheck"
                @camp-check="campCheck"
              />
            </div>
            <div class="form-group">
              <Items @img-status="imgStatus" id="test"/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-block create-account" @click="test">Create Account</button>
            </div>
        </form>
        
    </div>
    </body>
  </div>
  
</template>

<script>
import Filtermake from "@/components/mateparty/Filtermake.vue";
import Dropdown1 from "../../components/mateparty/dropdown/Dropdown1.vue";
import Dropdown2 from "../../components/mateparty/dropdown/Dropdown2.vue";
import Items from "@/components/mateparty/Items.vue";
import Campchoice from "@/components/mateparty/Campchoice.vue";
import Fileupload from "@/components/mateparty/Fileupload.vue";
import Datepicker from "@/components/mateparty/Datepicker.vue";
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;



export default {
  name: "Makeparty",
  components: {
    Items,
    Filtermake,
    Dropdown1,
    Dropdown2,
    Campchoice,
    Fileupload,
    Datepicker,
  },
  data: function () {
    return {
        partyData : {
          friendlimit : null,
          campStyleList : null,
          memberlimit : null,
          lowestAge : null,
          highestAge : null,
          mateCampsite : null,
          mateCampstart : null,
          mateCampend : null,
          mateCamptype: null,
          campEquipRequiredList : null,
          userNo : this.$store.state.myNum,
          mateTitle : null,
          mateContent: null,
          userNickname : this.$store.state.userList.userNickname
        },
        mateImageUrl : null,
        mateChatNm : null,
      }
  },
  created() {
    console.log(this.$store.state.userList);
    console.log(this.$store.state.mateList);
  },
  methods: {
    //image upload and preview methods
    selectImage() {
      this.$refs.fileInput.click();
    },
    pickFile() {
      let input = this.$refs.fileInput;
      let file = input.files;
      if (file && file[0]) {
        let reader = new FileReader();
        reader.onload = (e) => {
          this.previewImage = e.target.result;
        };
        reader.readAsDataURL(file[0]);
        this.$emit("input", file[0]);
      }
    },

    styleCheck() {
      const temp = {
        style1: null,
        style2: null,
        style3: null,
      };

      if (this.$store.state.styleCheck.length === 1) {
        temp.style1 = this.$store.state.styleCheck[0];
      } else if (this.$store.state.styleCheck.length === 2) {
        (temp.style1 = this.$store.state.styleCheck[0]), (temp.style2 = this.$store.state.styleCheck[1]);
      } else if (this.$store.state.styleCheck.length === 3) {
        (temp.style1 = this.$store.state.styleCheck[0]),
          (temp.style2 = this.$store.state.styleCheck[1]),
          (temp.style3 = this.$store.state.styleCheck[2]);
      }
      this.partyData.campStyleList = temp;
    },

    limitCheck(text) {
      this.partyData.friendlimit = Number(text);
    },
    campCheck() {
      this.partyData.mateCamptype = this.$store.state.campCheck[0];
    },
    memberValue(text) {
      this.partyData.memberlimit = Number(text);
    },
    ageValue1(text) {
      this.partyData.lowestAge = Number(text);
    },
    ageValue2(text) {
      this.partyData.highestAge = Number(text);
    },
    imgStatus(text) {
      this.partyData.campEquipRequiredList = text;
    },
    campValue(text,id) {
      console.log(text);
      console.log(id)
      this.$store.dispatch('campInfo',id)
      this.partyData.mateCampsite = text;
    },
    uploadedImage(file) {
      this.mateImageUrl = file;
      console.log(this.mateImageUrl);
    },
    dateIn(value) {
      console.log(value);

      if (value[0].toString().substring(4, 7) === "Jan") {
        var startMonth = "01";
      }
      if (value[0].toString().substring(4, 7) === "Feb") {
        startMonth = "02";
      } else if (value[0].toString().substring(4, 7) === "Feb") {
        startMonth = "02";
      } else if (value[0].toString().substring(4, 7) === "Mar") {
        startMonth = "03";
      } else if (value[0].toString().substring(4, 7) === "Apr") {
        startMonth = "04";
      } else if (value[0].toString().substring(4, 7) === "May") {
        startMonth = "05";
      } else if (value[0].toString().substring(4, 7) === "Jun") {
        startMonth = "06";
      } else if (value[0].toString().substring(4, 7) === "Jul") {
        startMonth = "07";
      } else if (value[0].toString().substring(4, 7) === "Aug") {
        startMonth = "08";
      } else if (value[0].toString().substring(4, 7) === "Sep") {
        startMonth = "09";
      } else if (value[0].toString().substring(4, 7) === "Oct") {
        startMonth = "10";
      } else if (value[0].toString().substring(4, 7) === "Nov") {
        startMonth = "11";
      } else if (value[0].toString().substring(4, 7) === "Dec") {
        startMonth = "12";
      }

      if (value[1].toString().substring(4, 7) === "Jan") {
        var endMonth = "01";
      }
      if (value[1].toString().substring(4, 7) === "Feb") {
        endMonth = "02";
      } else if (value[1].toString().substring(4, 7) === "Mar") {
        endMonth = "03";
      } else if (value[1].toString().substring(4, 7) === "Apr") {
        endMonth = "04";
      } else if (value[1].toString().substring(4, 7) === "May") {
        endMonth = "05";
      } else if (value[1].toString().substring(4, 7) === "Jun") {
        endMonth = "06";
      } else if (value[1].toString().substring(4, 7) === "Jul") {
        endMonth = "07";
      } else if (value[1].toString().substring(4, 7) === "Aug") {
        endMonth = "08";
      } else if (value[1].toString().substring(4, 7) === "Sep") {
        endMonth = "09";
      } else if (value[1].toString().substring(4, 7) === "Oct") {
        endMonth = "10";
      } else if (value[1].toString().substring(4, 7) === "Nov") {
        endMonth = "11";
      } else if (value[1].toString().substring(4, 7) === "Dec") {
        endMonth = "12";
      }
      const startYear = value[0].toString().substring(11, 15);
      const startDay = value[0].toString().substring(8, 10);
      const mateCampstart = startYear + "-" + startMonth + "-" + startDay;

      const endYear = value[1].toString().substring(11, 15);
      const endDay = value[1].toString().substring(8, 10);
      const mateCampend = endYear + "-" + endMonth + "-" + endDay;

      this.partyData.mateCampstart = mateCampstart;
      this.partyData.mateCampend = mateCampend;
    },

    test() {
      
      console.log(this.partyData)
      console.log(2)
      axios({
        method: "post",
        url : `${SERVER_URL}/mate`,
        data : this.partyData,
      })
      .then((res) => {
          // 이미지삽입
          console.log(res.data.dto.mateNo);
          this.mateChatNm = res.data.dto.mateNo;
          console.log(this.mateImageUrl);
          if (this.mateImageUrl) {
            axios({
              method: "post",
              headers: { "Content-Type": "multipart/form-data" },
              url: `${SERVER_URL}/mate/${res.data.dto.mateNo}`,

              data: this.mateImageUrl,
            })
              .then((res) => {
                console.log(res);
              })
              .catch((err) => {
                console.log(err);
              });
          }

          setTimeout(() => {
            this.$router.push({ name: "Mateparty" });
          }, 3000);

          // 채팅방
          const chatData = {
            title: this.partyData.mateTitle,
            masterId: this.$store.state.myNum,
            id: this.mateChatNm,
          };
          console.log(chatData);
        
          })
    
        .catch(err => {
          console.log(err)
        })
        
        setTimeout(()=> {this.$router.push({name:'Mateparty'})},3000)


        
        
   


      

    
      
 
  
        
    },
  },
};
</script>

<style scoped>
#test {
  padding : 0px;
  margin-left: 0px;
  margin-right : 0px;
  border-color: white;
  border-style:solid;
}

body {
  /* width: 768px; */
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
  background-color: #dee9ff;
}

.test {
  width: 100%;
}

.imagePreviewWrapper {
  background-repeat: no-repeat;
  width: 200px;
  height: 125px;
  display: block;
  cursor: pointer;
  margin: 0 auto 30px;
  background-size: contain;
  background-position: center center;
}

.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  /* margin-left: 50px; */
  /* margin-right: 20px; */
}
.filterbox2 {
  float: left;
}

.input1 {
  float: left;
  width: 250px;
  height: 32px;
  font-size: 15px;
  border: 2;
  /* border-br: red; */
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(224, 224, 224);
}

.contact-form {
  background: #fff;
  margin-top: 10%;
  margin-bottom: 5%;
  width: 100%;
}
.contact-form .form-control {
  border-radius: 1rem;
}

.form-control{
  border-radius: 20px;
}

.members{
  width:7.5rem;
  border-radius : 20px;
  float: left;
}

.ages{
  width:100px;
  height:100px;
  float: right;
}

.date{
  border-radius: 20px;
}

.contact-image {
  text-align: center;
}
.contact-image img {
  border-radius: 6rem;
  width: 11%;
  margin-top: -3%;
  transform: rotate(29deg);
}
.contact-form form {
  padding: 14%;
}
.contact-form form .row {
  margin-bottom: -7%;
}
.contact-form h3 {
  margin-bottom: 8%;
  margin-top: -10%;
  text-align: center;
  color: #0062cc;
}
.contact-form .btnContact {
  width: 50%;
  border: none;
  border-radius: 1rem;
  padding: 1.5%;
  background: #dc3545;
  font-weight: 600;
  color: #fff;
  cursor: pointer;
}
.btnContactSubmit {
  width: 50%;
  border-radius: 1rem;
  padding: 1.5%;
  color: #fff;
  background-color: #0062cc;
  border: none;
  cursor: pointer;
}

.camping {
  overflow: hidden;
  margin-top: 100px;
  margin-bottom: 40px;
}

.registration-form{
	padding: 50px 0;
}

.registration-form form{
    background-color: #fff;
    max-width: 7500px;
    margin: auto;
    padding: 50px 70px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}

.registration-form .form-icon{
	text-align: center;
    background-color: #5891ff;
    border-radius: 50%;
    font-size: 40px;
    color: white;
    width: 100px;
    height: 100px;
  
    margin-bottom: 50px;
    line-height: 100px;
}

.registration-form .item{
	border-radius: 20px;
    margin-bottom: 25px;
    padding: 10px 20px;
}

.registration-form .create-account{
    border-radius: 30px;
    padding: 10px 20px;
    font-size: 18px;
    font-weight: bold;
    background-color: #5791ff;
    border: none;
    color: white;
    margin-top: 20px;
}

.registration-form .social-media{
    max-width: 600px;
    background-color: #fff;
    margin: auto;
    padding: 35px 0;
    text-align: center;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    color: #9fadca;
    border-top: 1px solid #dee9ff;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}

.registration-form .social-icons{
    margin-top: 30px;
    margin-bottom: 16px;
}

.registration-form .social-icons a{
    font-size: 23px;
    margin: 0 3px;
    color: #5691ff;
    border: 1px solid;
    border-radius: 50%;
    width: 45px;
    display: inline-block;
    height: 45px;
    text-align: center;
    background-color: #fff;
    line-height: 45px;
}

.registration-form .social-icons a:hover{
    text-decoration: none;
    opacity: 0.6;
}

@media (max-width: 576px) {
    .registration-form form{
        padding: 50px 20px;
    }

    .registration-form .form-icon{
        width: 70px;
        height: 70px;
        font-size: 30px;
        line-height: 70px;
    }
}
</style>
