<template>
	<div>
		<div>
		<h1>회원가입하기</h1>
		<!-- input만들기 -->
		<b-col>
				<!-- 이메일 만들기 -->
				<b-row>
						<b-col>
								<b-form-group>
										<label style="float:left"
										>이메일</label>
										<b-form-input
										type="text"
										style="width:50%; float: left"
										placeholder="이메일을 입력하세요"
										autofocus>
										</b-form-input>
										<b-button>인증하기</b-button>
								</b-form-group>
						</b-col>
				</b-row>

				<!-- 이메일 인증번호 확인 -->
				<b-row>
						<b-col>
								<b-form-group>
										<label style="float:left"
										>인증번호</label>
										<b-form-input
										type="text"
										style="width:50%; float: left"
										placeholder="인증번호를 입력하세요"
										autofocus>
										</b-form-input>
										<b-button>확인</b-button>
								</b-form-group>
						</b-col>
				</b-row>

				<!-- 닉네임 중복확인 -->
				<b-row>
						<b-col>
								<b-form-group>
										<label style="float:left"
										>닉네임</label>
										<b-form-input
										type="text"
										style="width:50%; float: left"
										placeholder="닉네임을 입력하세요"
										autofocus>
										</b-form-input>
										<b-button>중복확인</b-button>
								</b-form-group>
						</b-col>
				</b-row>

				<!-- 비밀번호 -->
				<b-row>
						<b-col>
								<b-form-group>
										<label style="float:left"
										>비밀번호</label>
										<b-form-input
										type="text"
										style="width:50%; float: left"
										placeholder='비밀번호를 입력하세요'
										autofocus>
										</b-form-input>
								</b-form-group>
						</b-col>
				</b-row>

				<!-- 비밀번호 확인 -->
				<b-row>
						<b-col>
								<b-form-group>
										<label style="float:left"
										>비밀번호 확인</label>
										<b-form-input
										type="text"
										style="width:50%; float: left"
										placeholder="비밀번호를 한번 더 입력하세요"
										autofocus>
										</b-form-input>
								</b-form-group>
						</b-col>
				</b-row>

						<div>
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
										여자c
								</button>
								</div>
						</div>
				

						<div>
								<select name="지역" class="ui search dropdown btn btn-primary">
										<option value="서울">서울</option>
										<option value="서울">부산</option>
										<option value="서울">대구</option>
										<option value="서울">인천</option>
										<option value="서울">광주</option>
										<option value="서울">대전</option>
										<option value="서울">울산</option>
										<option value="서울">세종</option>
										<option value="서울">경기</option>
										<option value="서울">강원</option>
										<option value="서울">충북</option>
										<option value="서울">충남</option>
										<option value="서울">전북</option>
										<option value="서울">전남</option>
										<option value="서울">경북</option>
										<option value="서울">경남</option>
										<option value="서울">제주</option>
								</select>
						</div>

						<div>
								<select name="나이" class="ui search dropdown btn btn-primary">
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
		</b-col>
		
		</div>

		<!-- 여긴 기타 보유장비 -->
		<div>
			<input type="text">
		</div>

		<div>
			<!-- 여긴이미지 -->

		</div>


		<label>
		<input v-model="isTerm" type="checkbox" id="term" />
		<span>약관을 동의합니다.</span>
		</label>
		<span>약관보기</span>

		<div>
		<b-button variant="success">가입하기</b-button>
		
		<b-button variant="success"><router-link to="addSign">추가정보입력</router-link></b-button>
		</div>
	</div>
  
</template>

<script>
export default {
    name: 'Signup'
}
</script>

<style>

</style>