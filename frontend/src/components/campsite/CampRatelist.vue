<template>
  <div>
    <div v-for="(data, idx) in rateData" :key="idx">
      <div @click="goDetail(data.campRateNo)">{{ data.campRateTitle }}</div>
      <div>{{ data.campRateContent }}</div>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "CampRatelist",
  props: ["rateList"],
  setup(props) {
    const router = useRouter();
    console.log(props.rateList);
    const rateData = ref(props.rateList);
    const goDetail = (no) => {
      router.push({ name: "Campratedetail", params: { rateNo: no } });
    };

    return {
      rateData,
      goDetail,
    };
  },
};
</script>

<style></style>
