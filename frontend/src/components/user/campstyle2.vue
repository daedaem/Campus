<template>
	<div>
		<div>
			<h4 align="left">캠핑 스타일</h4>
			<hr>
			<ul class="list-inline">
                <li class="list-inline-item">
                    <button
                        :class="{
                            modifycampButtonOn: foodbutton,
                            modifycampButtonOff: !foodbutton,
                        }"
                        @click="styleControl('1')"
                        type="button"
                        >
                        음식/음주
                    </button> 
                </li>

                <li class="list-inline-item">
                    <button
                        :class="{
                            modifycampButtonOn: talkbutton,
                            modifycampButtonOff: !talkbutton,
                        }"
                        @click="styleControl('2')"
                        type="button"
                        >
                        불멍/수다
                    </button> 
                </li>

				<li class="list-inline-item">
                    <button
                        :class="{
                            modifycampButtonOn: campfirebutton,
                            modifycampButtonOff: !campfirebutton,
                        }"
                        @click="styleControl('3')"
                        type="button"
                        >
                        캠프파이어
                    </button> 
                </li>
				
                <li class="list-inline-item">
                    <button
                        :class="{
                            modifycampButtonOn: climbbutton,
                            modifycampButtonOff: !climbbutton,
                        }"
                        @click="styleControl('4')"
                        type="button"
                        >
                        등산
                    </button> 
                </li>

				<li class="list-inline-item">
                    <button
                        :class="{
                            modifycampButtonOn: photobutton,
                            modifycampButtonOff: !photobutton,
                        }"
                        @click="styleControl('5')"
                        type="button"
                        >
                        사진찍기
                    </button> 
                </li>
				
                <li class="list-inline-item">
                    <button
                        :class="{
                            modifycampButtonOn: musicbutton,
                            modifycampButtonOff: !musicbutton,
                        }"
                        @click="styleControl('6')"
                        type="button"
                        >
                        음악감상
                    </button>
                </li>
			</ul>
		</div>
	</div>
</template>

<script>
// import {ref} from 'vue'
export default {
	name: 'campstyle2',
    props: {
        campStyle1: {
            type: String
        },
        campStyle2: {
            type: String
        },
        campStyle3: {
            type: String
        },
        campStyle4: {
            type: String
        },
        campStyle5: {
            type: String
        },
        campStyle6: {
            type: String
        },
    },
    created: function () {
        if (this.campStyle1 === "Y") {
            this.styleStatus.campStyle1 = 1
            this.foodbutton = true
        } else {
            this.styleStatus.campStyle1 = 0
        }
        if (this.campStyle2 === "Y") {
            this.styleStatus.campStyle2 = 1
            this.talkbutton = true
        } else {
            this.styleStatus.campStyle2 = 0
        }
        if (this.campStyle3 === "Y") {
            this.styleStatus.campStyle3 = 1
            this.campfirebutton = SVGComponentTransferFunctionElement
        } else {
            this.styleStatus.campStyle3 = 0
        }
        if (this.campStyle4 === "Y") {
            this.styleStatus.campStyle4 = 1
            this.climbbutton = true
        } else {
            this.styleStatus.campStyle4 = 0
        }
        if (this.campStyle5 === "Y") {
            this.styleStatus.campStyle5 = 1

            this.photobutton = true
        } else {
            this.styleStatus.campStyle5 = 0
        }
        if (this.campStyle6 === "Y") {
            this.styleStatus.campStyle6 = 1
            this.musicbutton = true
        } else {
            this.styleStatus.campStyle6 = 0
        }
    },
    methods: {
        styleControl(x) {
            if ( x === '1') {
                if (this.styleStatus.campStyle1 === 0) {
                    this.styleStatus.campStyle1 = 1
                    this.foodbutton = true
                    console.log(this.styleStatus.campStyle1)
                } else  {
                    this.styleStatus.campStyle1 = 0
                    this.foodbutton = false
                }
            }

            if ( x === '2') {
                if (this.styleStatus.campStyle2 === 0) {
                    this.styleStatus.campStyle2 = 1
                    this.talkbutton = true
                    console.log(this.styleStatus.campStyle2)
                } else  {
                    this.styleStatus.campStyle2 = 0
                    this.talkbutton = false
                }
            }

            if ( x === '3') {
                if (this.styleStatus.campStyle3 === 0) {
                    this.styleStatus.campStyle3 = 1
                    this.campfirebutton = true
                    console.log(this.styleStatus.campStyle3)
                } else  {
                    this.styleStatus.campStyle3 = 0
                    this.campfirebutton = false
                }
            }

            if ( x === '4') {
                if (this.styleStatus.campStyle4 === 0) {
                    this.styleStatus.campStyle4 = 1
                    this.climbbutton = true
                    console.log(this.styleStatus.campStyle4)
                } else  {
                    this.styleStatus.campStyle4 = 0
                    this.climbbutton = false
                }
            }

            if ( x === '5') {
                if (this.styleStatus.campStyle5 === 0) {
                    this.styleStatus.campStyle5 = 1
                    this.photobutton = true
                    console.log(this.styleStatus.campStyle5)
                } else  {
                    this.styleStatus.campStyle5 = 0
                    this.photobutton = false
                }
            }

            if ( x === '6') {
                if (this.styleStatus.campStyle6 === 0) {
                    this.styleStatus.campStyle6 = 1
                    this.musicbutton = true
                    console.log(this.styleStatus.campStyle6)
                } else  {
                    this.styleStatus.campStyle6 = 0
                    this.musicbutton = false
                }
            }


            
        }
    },
    data() {
        return {
            styleStatus : {
                campStyle1 : 0,
                campStyle2 : 0,
                campStyle3: 0,
                campStyle4 : 0,
                campStyle5 : 0,
                campStyle6 : 0,
            },
            foodbutton: false,
            talkbutton: false,
            campfirebutton : false,
            climbbutton : false,
            photobutton : false,
            musicbutton : false,
        }
    },
    watch : {
        styleStatus: {
            handler(text) {
                this.$emit('style-status', text)
            },
            deep: true
        }
    },
}
</script>

<style scoped>
.modifycampButtonOn {
  
  color:black;
  /* font-size: 20px;
  line-height: 26px;
  padding-left: 35px; */
  background-color: blue;
  /* margin: 0;
  display: block;
  border: 5px solid #fff;
  border-top: none;
  border-right: none; */
  
}
.modifycampButtonOff {
  color:black;
  /* font-size: 20px;
  line-height: 26px;
  padding-left: 35px; */
  background-color: white;
  /* margin: 0;
  display: block;
  border: 5px solid #fff;
  border-top: none;
  border-right: none; */
}
</style>