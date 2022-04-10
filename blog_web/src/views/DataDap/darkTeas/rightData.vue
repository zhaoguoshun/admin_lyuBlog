<template>
  <div class="left-center">
    <div class="left-top">
      <dv-border-box-12>
        <div class="left-list">
          <div class="left-list-data">
            <div class="left-list-title">
              <dv-decoration-7>数字茶市</dv-decoration-7>
            </div>
            <div class="list-form">
              <div class="list-form boxtop">
                <div class="list-form-title">近五年常宁茶叶消费情况</div>
                <div id="top-left" style="height: 70%"></div>
              </div>
              <div class="list-form boxbottom">
                <div class="list-form-title">全国销售区域结构</div>
                <div id="top-left-bottom" style="height: 70%"></div>
              </div>
            </div>
          </div>
        </div>
      </dv-border-box-12>
      <dv-border-box-12>
        <div class="left-list">
          <div class="left-list-data">
            <div class="left-list-title">
              <dv-decoration-7>数字茶旅</dv-decoration-7>
            </div>
            <div class="list-form">
              <div class="list-form boxtop">
                <div class="list-form-title">近5年常宁旅游趋势</div>
                <div id="top-right" style="height: 50%;  width:95%"></div>
              </div>
              <div class="list-form boxbottom">
                <div class="list-form-title">产值结构图</div>
                <div id="right-radar" style="height:40%;  width:100%; "></div>
              </div>
            </div>
          </div>
        </div>
      </dv-border-box-12>
    </div>
    <div class="left-bottom">
      <dv-border-box-12>
        <div class="left-list">
          <div class="left-list-data">
            <div class="left-list-title">
              <dv-decoration-7>数字茶人</dv-decoration-7>
            </div>
            <div class="list-form">
              <div class="list-form boxtop">
                <div class="list-form-title">2020年茶叶消费用户行业排名</div>
                <div class="ranking-board-box">
                  <dv-scroll-ranking-board
                    :config="config"
                    style="width:100%;height:100%"
                  />
                </div>
              </div>
              <div class="list-form boxbottom">
                <div class="list-form-title">性别结构图</div>
                <div class="gender-box">
                  <div class="gender-box-list">
                    <img src="../../../assets/dpimg/man.6ed0c2d.png" alt="" />
                    <span>男性</span>
                    <span>61.3%</span>
                  </div>
                  <div class="gender-box-list">
                    <img src="../../../assets/dpimg/woman.48a2caa.png" alt="" />
                    <span>女性</span>
                    <span>38.7%</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </dv-border-box-12>
      <dv-border-box-12>
        <div class="left-list">
          <div class="left-list-data">
            <div class="left-list-title">
              <dv-decoration-7>数字茶政</dv-decoration-7>
            </div>
            <div class="list-form">
              <div class="list-form boxtop">
                <div class="list-form-title">市场监控</div>
                <div class="chart-box">
                  <dv-flyline-chart
                    :config="config2"
                    style="width:100%;height:100%;"
                  />
                </div>
              </div>
              <div class="list-form boxbottom">
                <div class="bottom-img">
                  <img src="../../../assets/dpimg/cargo_control.png" alt="" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </dv-border-box-12>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "LeftItem",
  data() {
    return {
      //近五年常宁茶叶消费情况
      option1: {
        legend: {},
        tooltip: {},
        dataset: {
          source: [
            ["2016", 3.2],
            ["2017", 3.4],
            ["2018", 4.2],
            ["2019", 4.8],
            ["2020", 5.3]
          ]
        },
        xAxis: { type: "category" },
        yAxis: {},
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [{ type: "bar" }]
      },
      //全国销售区域结构
      option3: {
        tooltip: {
          trigger: "item"
        },
        legend: {
          top: "top",
          data: []
        },
        series: [
          {
            type: "pie",
            radius: "48%",
            center: ["50%", "40%"],
            label: {
              position: "inner",
              color: "#fff",
              fontSize: "8"
            },
            data: [
              { value: 100, name: "其他" },
              { value: 1820, name: "湖南" },
              { value: 200, name: "云南" },
              { value: 484, name: "广西" },
              { value: 300, name: "湖北" }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            }
          }
        ]
      },
      //近5年安化旅游趋势
      option: {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            // type: 'cross',
            label: {
              backgroundColor: "#6a7985"
            }
          }
        },
        legend: {
          data: ["Email", "Union Ads", "Video Ads", "Direct", "Search Engine"]
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true
        },
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: ["2016", "2017", "2018", "2019", "2020"]
          }
        ],
        yAxis: [
          {
            type: "value"
          }
        ],
        series: [
          {
            name: "人次",
            type: "line",
            stack: "Total",
            areaStyle: {},
            emphasis: {
              focus: "series"
            },
            data: [15, 30, 90, 200, 500]
          }
        ]
      },
      //产值结构图
      option2: {
        tooltip: {
          trigger: "item"
        },
        radar: {
          radius: "50",
          indicator: [
            { text: "东北地区", max: 40 },
            { text: "华北地区", max: 40 },
            { text: "西南地区", max: 40 },
            { text: "西北地区", max: 40 },
            { text: "东南地区", max: 40 }
          ],
          name: {
            fontSize: 10,
            color: "#0efcff"
          }
        },
        series: (function() {
          let series = [];
          series.push({
            type: "radar",
            name: "销量品牌分布",
            symbol: "none",
            lineStyle: {
              width: 2,
              color: "#0efcff"
            },
            label: {
              fontSize: 12
            },
            areaStyle: {
              color: "#0efbff60"
            },
            emphasis: {
              areaStyle: {
                color: "rgba(0,250,0,0.5)"
              }
            },
            data: [
              {
                value: [35, 35, 40, 38, 29]
              }
            ]
          });
          return series;
        })()
      },
      //2020年黑茶消费用户行业排名
      config: {
        data: [
          {
            name: "金融业",
            value: 120
          },
          {
            name: "房地产",
            value: 80
          },
          {
            name: "制造业",
            value: 58
          },
          {
            name: "传媒",
            value: 26
          },
          {
            name: "其他",
            value: 15
          }
        ]
      },
      config2: {
        centerPoint: [0.48, 0.35],
        points: [
          {
            position: [0.52, 0.235]
          },
          {
            position: [0.43, 0.29]
          },
          {
            position: [0.59, 0.35]
          },
          {
            position: [0.53, 0.47]
          },
          {
            position: [0.45, 0.54]
          },
          {
            position: [0.36, 0.38]
          },
          {
            position: [0.62, 0.55]
          },
          {
            position: [0.56, 0.56]
          },
          {
            position: [0.37, 0.66]
          },
          {
            position: [0.55, 0.81]
          },
          {
            position: [0.55, 0.67]
          },
          {
            position: [0.37, 0.29]
          },
          {
            position: [0.2, 0.36]
          },
          {
            position: [0.76, 0.41]
          },
          {
            position: [0.59, 0.18]
          },
          {
            position: [0.68, 0.17]
          },
          {
            position: [0.59, 0.1]
          }
        ],
        k: 0.5,
        bgImgUrl: "http://datav.jiaminghi.com/img/flylineChart/map.jpg",
        centerPointImg: {
          url: "http://datav.jiaminghi.com/img/flylineChart/mapCenterPoint.png"
        },
        pointsImg: {
          url: "http://datav.jiaminghi.com/img/flylineChart/mapPoint.png"
        }
      }
    };
  },
  mounted() {
    this.topleft();
    this.topleftbottom();
    this.drawLine();
    this.rightradar();
  },
  methods: {
    topleft() {
      let myChart = echarts.init(document.getElementById("top-left"));
      this.option1 && myChart.setOption(this.option1);
    },
    topleftbottom() {
      let myChart = echarts.init(document.getElementById("top-left-bottom"));
      this.option3 && myChart.setOption(this.option3);
    },
    drawLine() {
      let myChart = echarts.init(document.getElementById("top-right"));
      this.option && myChart.setOption(this.option);
    },
    rightradar() {
      let myChart = echarts.init(document.getElementById("right-radar"));
      this.option2 && myChart.setOption(this.option2);
    }
  }
};
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
.left-list-title {
  font-size: 15px;
  margin-top: 15px;
}
.list-form {
  height: 100%;
  width: 100%;
  position: relative;
}
.list-form-title {
  position: absolute;
  top: 20px;
  left: 15px;
  color: #0efcff;
}
.boxbottom {
  position: relative;
  top: -46%;
  left: 0;
}
#right-radar {
  position: absolute;
  top: 20px;
}
.ranking-board-box {
  position: absolute;
  top: 40px;
  left: 15px;
  width: 80%;
  height: 145px;
}
::v-deep .ranking-info {
  font-size: 8px !important;
}
.gender-box {
  position: absolute;
  top: 50px;
  left: 5px;
  width: 100%;
  height: 200px;
  position: relative;
  display: flex;
}
.gender-box-list {
  flex: 1;
  text-align: center;
  justify-content: center;
  align-items: center;
}
.gender-box img {
  width: 85px;
  height: 80px;
  display: block;
  margin: 0 5px;
}
.chart-box {
  position: absolute;
  width: 90%;
  height: 50%;
  top: 40px;
  left: 5%;
}
.bottom-img {
  position: absolute;
  top: 60px;
  width: 100%;
  height: 80px;
  text-align: center;
}
.bottom-img img {
  width: 95%;
}
</style>
