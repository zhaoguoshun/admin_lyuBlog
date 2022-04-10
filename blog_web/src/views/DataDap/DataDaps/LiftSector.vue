<template>
    <div id="container" style="height: 80%"></div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "LiftSector",
  data() {
    return {
  
    }
  },
  mounted(){
    this.drawLine();
  },
  methods: {
      drawLine() {
          let myChart = echarts.init(document.getElementById('container'));
           let option = {
            tooltip: {
                trigger: 'item'
            },
            legend: {
                top: '5%',
                left: 'center'
            },
             series: [
            {
                top: '5%',
                type: 'pie',
                color: [
                      '#0dbb55c0','#dfdb09c0', '#f54c4c',
                ],
                radius: ['30%', '60%'],
                avoidLabelOverlap: false,
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                    show: true,
                    fontSize: '20',
                    fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: [
                    { value: 580, name: '正常' },
                    { value: 484, name: '警告' },
                    { value: 300, name: '故障' },
                    
                 ]
              }
             ],
        };
         myChart.setOption(option);
      setTimeout(function() {
        window.onresize = function() {
          myChart.resize();
        };
      }, 200);
      }
  }

};

</script>

<style scoped>
/* #container {
  position: relative;
  width: 100%;
} */
</style>