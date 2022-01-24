<template>
	<div>
		<div class="wrapC">
			<h1>추가정보입력</h1>

      <div class="item-box">
        <div align="left" class="filterbox">
					<div align="left" class="filterbox2">나이
						<age_Dropdown/>
					</div>
          <div align="left" class="filterbox2">거주 지역
						<area_Dropdown/>
					</div>

          <div align="left" class="filterbox">
            <div>
              성별
            </div>
            <div>
            <button 
                class="btn btn-danger"
                @click="clickMale">
                남자
            </button>
            <button
                class="btn btn-primary"
                @click="clickFemale">
                여자
            </button>
            </div>
				</div>
				</div>
      </div>


			<!-- 아이템선택 -->
				<div class="mt-3">
					<Items/>
				</div>
        <div class="item-box mt-3">
					<EquipInput/>
					<EquipList/>
				</div>
		</div>
	</div>
</template>

<script>
import Items from '@/components/user/Items.vue'
import EquipInput from '@/components/user/equip_input.vue'
import EquipList from '@/components/user/equip_list.vue'
import area_Dropdown from '../../components/user/area_Dropdown.vue'
import age_Dropdown from '../../components/user/age_Dropdown.vue'

export default {
	name: 'addSign',
	components: {
		Items,
		EquipInput,
		EquipList,
    area_Dropdown,
		age_Dropdown,
	},
}
</script>

<style>
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

body {
  text-align: center;
  background-color: #F6F6F6;
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
  float: left;
} 
</style>