<template>
    <div class="board">
        <dv-scroll-board :config="config" style="width:95%;height:180px"/>
    </div>
</template>

<script>
export default {
  name: "LiftBoard",
  data() {
    return {
        config: {
           header: ['监测类别', '正常指数', '警告指数'],
           data: [
                ['重金属', '2', '0'],
                ['非甲烷总烃', '2', '0'],
                ['烟气黑度', '2', '0'],
                ['TSP', '2', '0'],
                ['烟尘', '2', '0'],
                ['PM10', '2', '0'],
                ['TVOC', '2', '0'],
                ['苯系物', '2', '0'],
                ['盐酸雾', '2', '0'],
                ['氟化氢', '2', '0'],
                ['硫酸雾', '2', '0'],
                ['铬酸雾', '2', '0'],
             ] ,
             align: ['center','center','center'],
        }
    }
  },
  mounted(){
  },
  methods: {

  }

};

</script>

<style scoped>
.board {
    padding: 15px 10px 0 35px;
}
.row-item {
  text-align: center !important;
}
</style>