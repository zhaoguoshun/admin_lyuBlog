<template>
  <div id="firmInfo">
    <dv-scroll-board :config="config" />
  </div>
</template>

<script>
export default {
  name: "FirmInfo",
  props: ["firmInfoData"],
  data() {
    return {
      config: {
        header: [
          "企业名称",
          "员工人数",
          "今日识别员工次数",
          "今日识别陌生人次数"
        ],
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
    firmInfoData: {
      handler: function(newVal, oldVal) {
        this.config = {
          header: [
            "企业名称",
            "员工人数",
            "今日识别员工次数",
            "今日识别陌生人次数"
          ],
          data: [
            [
              newVal.deptName,
              newVal.personCount,
              newVal.todayPerson,
              newVal.todayStranger
            ],
            ["长沙珂信肿瘤医院", 10, 6, 4],
            ["长沙音乐厅", 10, 6, 4],
            ["常宁市中医院", 10, 6, 4],
            ["常宁文化执法大队", 10, 6, 4],
            ["郴州宜章县中医院", 10, 6, 4],
            ["常宁文化执法大队", 10, 6, 4],
            ["城步县人民医院", 10, 6, 4],
            ["东坪镇安化县人民医院", 10, 6, 4]
          ],
          rowNum: 6,
          headerBGC: "#1981f6",
          headerHeight: 45,
          oddRowBGC: "rgba(0, 44, 81, 0.8)",
          evenRowBGC: "rgba(10, 29, 50, 0.8)"
        };
      },
      deep: true
    }
  }
};
</script>

<style lang="scss" scoped>
#firmInfo {
  width: 100%;
  box-sizing: border-box;
  height: 100%;
  overflow: hidden;
  // text-align: center;
}
</style>
