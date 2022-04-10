<template>
  <div id="tea-company">
    <dv-full-screen-container>
      <top-header />
      <div class="content">
            <img src="@/assets/下载.png" class="back" @click="$router.go(-1)" />
        <div class="content-left">
          <tabmuen />
        </div>
        <div class="content-right">
          <container />
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
import bottomData from "./darkTeas/bottomData";
import Tabmuen from "./teaCompany/Tabmuen";
import Container from "./TeaEnterprise/Container";
export default {
  name: "TeaCompany",
  components: { topHeader, bottomData, Tabmuen, Container },
  data() {
    return {};
  },
  mounted() {},
  created() {}
};
</script>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}
#tea-company {
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
  height: 95%;
}
.content-left {
  flex: 1;
  display: flex;
}
.content-right {
  flex: 4;
  display: flex;
  position: relative;
  .right-left {
    flex: 7;
  }
  .right-right {
    flex: 4;
  }
}
.bottom {
  width: 100%;
  height: 50px;
}
  .back {
    width: 40px;
    position: absolute;
    top: 85px;
    left: 230px;
    z-index: 999;
    cursor: pointer;
  }
</style>
