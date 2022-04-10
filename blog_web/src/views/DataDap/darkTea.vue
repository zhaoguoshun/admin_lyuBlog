<template>
  <div id="data-view">
    <dv-full-screen-container>
      <top-header />
      <div class="content">
        <div class="content-left">
          <left-data />
        </div>
        <div class="content-center">
          <center-data />
        </div>
        <div class="content-right">
          <right-data />
        </div>
      </div>
      <div class="bottom">
        <bottom-data />
      </div>
    </dv-full-screen-container>
  </div>
</template>

<script>
import topHeader from "./darkTeas/topHeader";
import LeftData from "./darkTeas/LeftData";
import rightData from "./darkTeas/rightData";
import bottomData from "./darkTeas/bottomData";
import centerData from "./darkTeas/centerData";
import { getPolling } from "@/api/dataScreen";
export default {
  name: "darkTea",
  components: {
    topHeader,
    LeftData,
    rightData,
    bottomData,
    centerData
  },
  data() {
    return {};
  },
  mounted() {
    setInterval(() => {
      getPolling();
    }, 50000);
  },
  created() {},
  methods: {}
};
</script>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}
#data-view {
  width: 100%;
  height: 100%;
  color: #fff;
}
#dv-full-screen-container {
  background: url(../../assets/darkTea.jpg) no-repeat top center;
  background-size: 100% 100%;
  display: flex;
  flex-direction: column;
}
.content {
  display: flex;
  height: 100%;
}
.content-left {
  flex: 2;
  display: flex;
}
.content-center {
  flex: 3;
}
.content-right {
  flex: 2;
}
.bottom {
  width: 100%;
  height: 50px;
  padding-top: 5px;
}
</style>
