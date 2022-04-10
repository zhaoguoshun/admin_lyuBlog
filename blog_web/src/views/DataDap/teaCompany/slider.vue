<template>
  <div style="width:100%;height:100%;">
    <dv-scroll-board :config="config" style="width:100%;height:95%" />
    <!-- 茶企轮播表 -->
  </div>
</template>

<script>
export default {
  name: "YearOnYear",
  props: ["sliderData"],
  data() {
    return {
      config: {
        header: ["区域", "数量", "产量", "产值"],
        data: [
          ["江河乡", "0", "0", "0"],
          ["柏坊镇", "0", "0", "0"],
          ["水口山街道", "2", "1.03万吨", "2.16亿"],
          ["松柏镇", "1", "0.60万吨", "1.26亿"],
          ["烟洲镇", "1", "1.82万吨", "3.80亿"],
          ["蓬塘乡", "2", "0.41万吨", "0.86亿"],
          ["宜潭乡", "2", "1.44万吨", "3.02亿"],
          ["新河镇", "3", "0.44万吨", "0.93亿"],
          ["大堡乡", "2", "1.03万吨", "2.16亿"],
          ["官岭镇", "1", "0.60万吨", "1.26亿"],
          ["兰江乡", "1", "1.82万吨", "3.80亿"],
          ["培元街道", "0", "0", "0"],
          ["宜阳街道", "0", "0", "0"],
          ["泉峰街道", "0", "0", "0"],
          ["盐湖镇", "1", "1.82万吨", "3.80亿"],
          ["荫田镇", "1", "1.82万吨", "3.80亿"],
          ["西岭镇", "1", "1.82万吨", "3.80亿"],
          ["三角塘镇", "1", "1.82万吨", "3.80亿"],
          ["板桥镇", "1", "1.82万吨", "3.80亿"],
          ["胜桥镇", "1", "1.82万吨", "3.80亿"],
          ["洋泉镇", "5", "1.82万吨", "3.80亿"],
          ["罗桥镇", "1", "1.82万吨", "3.80亿"],
          ["白沙镇", "1", "1.82万吨", "3.80亿"],
          ["庙前镇", "1", "1.82万吨", "3.80亿"],
          ["弥泉乡", "1", "1.82万吨", "3.80亿"],
          ["塔山瑶族乡", "8", "1.82万吨", "3.80亿"],
          ["天堂山办事处", "3", "1.82万吨", "3.80亿"]
        ],
        headerBGC: "#00000000",
        oddRowBGC: "#00000000",
        evenRowBGC: "#00000000",
        align: ["center", "center", "center", "center"],
        rowNum: 5
        // columnWidth:[50,40,60,50]
      }
    };
  },
  watch: {
    sliderData: {
      deep: true,
      handler: function(newValue, oldValue) {
        let sliderList = [];
        for (let i = 0; i < newValue.length; i++) {
          let item = [];
          item.push(newValue[i][0]);
          item.push(newValue[i][1]);
          item.push(newValue[i][2]);
          item.push(newValue[i][3]);
          sliderList.push(item);
        }
        this.config = {
          header: ["区域", "数量", "产量", "产值"],
          data: sliderList,
          headerBGC: "#00000000",
          oddRowBGC: "#00000000",
          evenRowBGC: "#00000000",
          align: ["center", "center", "center", "center"],
          rowNum: 5
        };
      }
    }
  },
  mounted() {},
  methods: {}
};
</script>

<style lang="scss" scoped>
::v-deep .header-item {
  padding: 0 !important;
  font-size: 10px !important;
  color: #0efcff;
}
::v-deep .dv-scroll-board .rows .ceil {
  padding: 0;
  font-size: 12px;
  display: inline-block;
  vertical-align: middle;
}
::v-deep .header {
  justify-content: center !important;
  align-items: center !important;
  margin: 0 5px;
  font-size: 14px;
}
::v-deep .row-item {
  justify-content: center !important;
  align-items: center !important;
  margin: 0 5px;
  font-size: 14px;
}
</style>
