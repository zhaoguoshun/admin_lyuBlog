<template>
    <div class="left-center">
         <div class="left-top">
             <dv-border-box-12>
                 <div class="left-list">
                     <div class="left-list-data">
                         <div class="left-list-title">
                             <dv-decoration-7>数字茶园</dv-decoration-7>
                         </div>
                             <dv-scroll-board :config="config" style="width:100%;height:95%" />
                     </div>
                 </div>
             </dv-border-box-12>
             <dv-border-box-12>
                 <div class="left-list">
                      <div class="left-list-data">
                         <div class="left-list-title">
                             <dv-decoration-7>数字茶企</dv-decoration-7>
                         </div>
                         <dv-scroll-board :config="config" style="width:100%;height:95%" />
                     </div>
                 </div>
            </dv-border-box-12> 
         </div>
         <div class="left-bottom">
             <dv-border-box-12>
                 <div class="left-list">
                     <div class="left-list-data">
                         <div class="left-list-title">
                             <dv-decoration-7>数字茶农</dv-decoration-7>
                         </div>
                         <dv-scroll-board :config="config" style="width:100%;height:95%" />
                     </div>
                 </div>
             </dv-border-box-12>
             <dv-border-box-12>
                 <div class="left-list">
                      <div class="left-list-data">
                         <div class="left-list-title">
                             <dv-decoration-7>数字茶仓</dv-decoration-7>
                         </div>
                         <div class="data-form">
                                <div class="header-title">茶仓基本信息</div>
                                <table border="1" cellspacing="0" >
                                    <tr>
                                        <td>仓库名称：</td>
                                        <td>常宁总仓</td>
                                    </tr>
                                    <tr>
                                        <td>地理位置：</td>
                                        <td>塔山瑶族乡</td>
                                    </tr>
                                    <tr>
                                        <td>茶仓管理方：</td>
                                        <td>谷佳茶业开发有限责任公司</td>
                                    </tr>
                                    <tr>
                                        <td>评级：</td>
                                        <td>AAAAAA</td>
                                    </tr>
                                    <tr>
                                        <td>类型：</td>
                                        <td>干仓</td>
                                    </tr>
                                </table>
                         </div>
                         <div class="trend-chart">
                            <div class="trend-chart-title">出入仓走势图</div>
                            <div id="trend-chart" style="height: 50%"></div>  
                         </div>
                            
                     </div>
                 </div>
            </dv-border-box-12> 
         </div>
    </div>
</template>

<script>
import * as echarts from 'echarts';
export default {
    name: "LeftItem",
    data() {
        return {
            config:{
                header: ['区域', '数量', '产量', '产值'],
                data: [
                    ['白沙镇', '741', '1.06万吨', '2.21亿'],
                    ['柏坊镇', '254', '0.88万吨', '1.84亿'],
                    ['板桥镇', '313', '1.03万吨', '2.16亿'],
                    ['大堡乡', '270', '0.60万吨', '1.26亿'],
                    ['官岭镇', '509', '1.82万吨', '3.80亿'],
                    ['江河乡', '301', '0.41万吨', '0.86亿'],
                    ['兰江乡', '519', '1.44万吨', '3.02亿'],
                    ['罗桥镇', '126', '0.44万吨', '0.93亿'],
                    ['弥泉乡', '313', '1.03万吨', '2.16亿'],
                    ['庙前镇', '270', '0.60万吨', '1.26亿'],
                    ['蓬塘乡', '509', '1.82万吨', '3.80亿'],
             
                    
            ],
                    headerBGC:'#00000000',
                    oddRowBGC:'#00000000',
                    evenRowBGC:'#00000000',
                    align: ['center','center','center','center'],
                    rowNum:8,
                    // columnWidth:[50,40,60,50]
            },
            option:{
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                // type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
                }
            },
            legend: {
                data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine']
            },
            toolbox: {
                feature: {
                saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                type: 'category',
                boundaryGap: false,
                data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月' ]
                }
            ],
            yAxis: [
                {
                type: 'value'
                }
            ],
            series: [
                {
                name: '入仓',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [0, 10, 15, 20, 20, 40, 15, 30, 20, 20, 0, 20]
                },
                {
                name: '出仓',
                type: 'line',
                stack: 'Total',
                label: {
                    show: true,
                    position: 'top'
                },
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [15, 20, 20, 40, 30, 20, 10, 20, 30, 30, 20, 0]
                }
            ]
            }
            

        };
       
    },
 mounted(){
    this.drawLine();
  },
  methods:{
       drawLine(){
            let myChart = echarts.init(document.getElementById('trend-chart'));
            this.option && myChart.setOption(this.option);
       }
  }
    }
</script>
<style lang="scss" scoped>
.left-center {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
  .left-top {
    flex: 1;
    display: flex;
    margin-bottom: 10px;
  }
  .left-bottom {
    flex: 1;
    display: flex;
  }
}
.left-list {
    flex: 1;
    height: 100%;
    width: 100%;
    position: absolute;
    // margin: 6px 10px 15px 10px;
    .left-list-data {
        position: absolute;
        top: 0;
        left: 0;
        height: 90%;
        width: 100%;
    }
}
// #dv-scroll-board {
//     width: 100%;
//     height: 98%;
    
// }
::v-deep .header-item  {
    padding: 0 !important;
    font-size: 10px !important;
    color: #0efcff;
}
::v-deep .dv-scroll-board .rows .ceil {
    padding: 0  ;
    font-size: 10px;
    display: inline-block;
    vertical-align: middle;
    
}
::v-deep  .header {
        justify-content: center !important;
        align-items: center !important;
        margin: 0 5px;
    }
::v-deep .row-item {
        justify-content: center !important;
        align-items: center !important;
        margin: 0 5px;
    }
.left-list-title {
    font-size: 15px;  
    margin-top: 15px;
    
}
.data-form {
    width: 100% !important; 
    font-size: 0.12rem;
    color: #0efcff;
}
.data-form table {
    text-align: left;
   
    margin: 0 5%;
    width: 90%;
    line-height: 1.3em;
    font-size: 0.12rem;
    border: 1px solid #0efcff;
}
// .data-form table td {
//     border: 1px solid #0efcff;
// }
.header-title {
    margin: 15px 0 10px 15px;
}
.trend-chart {
    height: 100%;
    position: relative;
}
.trend-chart-title {
    position: absolute;
    top: 10px;
    left: 10px;
    color: #0efcff;
}
</style>