<template>
  <div>
      <!-- <h4>캠핑장 선택</h4>
      <input list="brow" placeholder="캠핑장 ">
  <datalist id="brow">
    <option value="Internet Explorer"></option>
    <option value="Firefox"></option>
    <option value="Chrome"></option>
    <option value="Opera"></option>
    <option value="Safari"></option>
  </datalist>   -->

  <div class="ui icon input" style="width: 100%">
    <input type="text" placeholder="캠핑장 선택.." v-on:input="test" :value="searchQuery"/>
    <i class="search icon"></i>
  </div>
    <div class="ui cards" style="margin: 10px" v-if="searchQuery">
    <div
      class="card ui fluid"
      v-for="(camp,idx) in searchedProducts"
      :key="idx"
      style="margin: 0"
    >
      <div class="content" @click="doSelect(camp.facltNm)">
        <div style="float:left;">
        <img class="right floated mini ui image" :src="camp.firstImageUrl" style="width:50px; height:50px;"/>
        </div>
        <div class="header" style="margin-left:70px;">{{ camp.facltNm }}</div>
        <div class="meta" style="margin-left:70px;">
          {{ camp.addr1 }} | 
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import {useStore} from 'vuex'
import {ref, computed, reactive} from 'vue'
export default {
  emits : ['camp-data'],
  name : 'Campchoice',
  setup(props,{emit}) {
    // console.log(2)
    const store = useStore()
    const campList = reactive(store.state.campList)
    const searchQuery = ref("");
    const test = (e) => { searchQuery.value = e.target.value}

    console.log(campList)
    const searchedProducts = computed(() => {
      return campList.filter((camp) => {
        return (
          camp.facltNm
            .toLowerCase()
            .indexOf(searchQuery.value.toLowerCase()) != -1
        );
      });
    });
    
    const doSelect = (name) => {
      searchQuery.value = name
      emit('camp-data', name)
    }

    return {
      campList,
      searchQuery,
      searchedProducts,
      test,
      doSelect
    }
  }
}

</script>

<style scoped>

input {
  width : 100%;
  height : 2.5rem;
  border-radius : 20px;
  padding-left: 20px;
}

</style>