<template>
  <div class="tabBox">
    <ul>
      <li>
        <img
          class="active-w"
          src="../../../assets/images/cha_zheng.png"
          @click="goBack()"
        />
      </li>
      <li>
        <img
          class="active-menu"
          src="../../../assets/images/cha_qi_jh (1).png"
          @click="goTeaCompany()"
        />
      </li>
      <li>
        <img
          class="active-c"
          src="../../../assets/images/cha_yuan.png"
          alt=""
        />
      </li>
      <li>
        <img
          class="active-x"
          src="../../../assets/images/cha_nong.png"
          alt=""
        />
      </li>
      <li>
        <img
          class="active-x"
          src="../../../assets/images/cha_cang.png"
          alt=""
        />
      </li>
      <li>
        <img class="active-c" src="../../../assets/images/cha_lv.png" alt="" />
      </li>
      <li>
        <img class="active-y" src="../../../assets/images/cha_shi.png" alt="" />
      </li>
      <li>
        <img class="active-w" src="../../../assets/images/cha_ren.png" alt="" />
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "Tabmuen",
  data() {
    return {};
  },
  methods: {
    goBack() {
      this.$router.push("/darkTea");
    },
    goTeaCompany() {
      this.$router.push("/TeaCompany");
    }
  }
};
</script>
<style lang="scss" scoped>
.tabBox {
  margin-top: 50px;
  margin-left: 15px;
  width: 20%;
  height: calc(100% - 9.64vw);
  position: absolute;
  left: 0;
  top: 5.5vw;
  z-index: 1000;
  ul li {
    list-style: none;
    height: 9vh;
    text-align: right;
    padding-right: 3vw;

    .active-w {
      margin-right: 2vw;
    }
    .active-y {
      margin-right: 3vw;
    }
    .active-c {
      margin-right: 4vw;
    }
    .active-menu {
      margin-right: 2vw;
    }
    .active-x {
      margin-right: 5vw;
    }

    img {
      width: 66%;
      cursor: pointer;
      text-align: right;
    }
  }
}
</style>
