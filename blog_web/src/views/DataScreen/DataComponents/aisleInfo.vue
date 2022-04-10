<template>
  <div id="aisleInfo">
    <dv-scroll-board :config="config" />
  </div>
</template>

<script>
export default {
  name: "AisleInfo",
  props: ["domainData"],
  data() {
    return {
      config: {
        header: ["通道名称", "今日识别员工数", "今日识别访客数", "启用状态"],
        data: [],
        rowNum: 6,
        headerBGC: "#1981f6",
        headerHeight: 45,
        oddRowBGC: "rgba(0, 44, 81, 0.8)",
        evenRowBGC: "rgba(10, 29, 50, 0.8)"
      }
    };
  },
  watch: {
    domainData: {
      handler: function(newVal, oldVal) {
        let domainList = [];
        for (let i = 0; i < newVal.length; i++) {
          let item = [];
          item.push(newVal[i].domainName);
          item.push(newVal[i].todayPersonCount.toString());
          item.push(newVal[i].todayStrangerCount.toString());
          item.push(newVal[i].status);
          domainList.push(item);
        }

        let item = [];
        item.push("东门");
        item.push(128);
        item.push(20);
        item.push("正常");
        domainList.push(item);
        item = [];
        item.push("西门");
        item.push(128);
        item.push(20);
        item.push("正常");
        domainList.push(item);
        item = [];
        item.push("南门");
        item.push(128);
        item.push(20);
        item.push("正常");
        domainList.push(item);
        item = [];
        item.push("北门");
        item.push(128);
        item.push(20);
        item.push("正常");
        domainList.push(item);
        item = [];
        item.push("办公大楼");
        item.push(54);
        item.push(3);
        item.push("正常");
        domainList.push(item);
        item = [];
        item.push("门诊部");
        item.push(12);
        item.push(280);
        item.push("正常");
        domainList.push(item);
        item = [];
        item.push("住院部");
        item.push(32);
        item.push(170);
        item.push("正常");
        domainList.push(item);

        this.config = {
          header: [
            "通道名称",
            "今日识别员工次数",
            "今日识别陌生人次数",
            "启用状态"
          ],
          data: domainList,
          rowNum: 6,
          headerBGC: "#1981f6",
          headerHeight: 45,
          oddRowBGC: "rgba(0, 44, 81, 0.8)",
          evenRowBGC: "rgba(10, 29, 50, 0.8)"
        };
      },
      deep: true
    }
  },
  mounted() {}
};
</script>

<style lang="scss" scoped>
#aisleInfo {
  width: 100%;
  box-sizing: border-box;
  height: 100%;
  overflow: hidden;
}
</style>
