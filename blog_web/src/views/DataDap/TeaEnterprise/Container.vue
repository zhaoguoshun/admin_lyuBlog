<template>
  <div class="container">
    <div class="box">
      <div class="title">
        企业基本信息
      </div>
      <div class="details">
          <div class="details-img">
            <img src="@/assets/images/qianqiujie.jpg" alt="">
          </div>
          <div class="details-title">
            <p class="title-left">常宁市谷佳茶业开发有限责任公司</p>
            <p class="title-left">主体类型：<span>中小企业</span></p>
            <p class="title-left">种植面积：<span>1000亩</span></p>
            <p class="title-left">企业性质：<span>有限责任公司</span></p>
            <p class="title-left">成立时间：<span>2016年05月09日</span></p>
            <p>负责人／法人：<span>周连友</span><span class="location">信用代码:<span>91430482MA4L47LQ0K</span></span></p>
            <p>经营现状：<span>存续</span><span class="location location-bottom">注册资本:<span>3000万人民币</span></span></p>
            <p>地址：<span>湖南省衡阳市常宁市塔山乡敖头村谷家组</span></p>
            <p class="text">简介：<span>主要经营茶叶（紧压茶、黑茶、绿茶、红茶）生产、加工、销售，生态农业、旅游开发</span></p>
          </div>
      </div>
    </div>
    <div class="box">
      <div class="title">
        设备实时监测
      </div>
      <table data-v-190bfe6d="" border="1" class="baseTable">
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">名称</td>
          <td data-v-190bfe6d="">类型</td>
          <td data-v-190bfe6d="" class="">状态</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">设备1</td>
          <td data-v-190bfe6d="">勘测土壤</td>
          <td data-v-190bfe6d="" class="">正常</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">设备2</td>
          <td data-v-190bfe6d="">勘测气象</td>
          <td data-v-190bfe6d="" class="">正常</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">设备3</td>
          <td data-v-190bfe6d="">田间管理</td>
          <td data-v-190bfe6d="" class="">正常</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">设备4</td>
          <td data-v-190bfe6d="">遥感无人机</td>
          <td data-v-190bfe6d="" class="">正常</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">设备5</td>
          <td data-v-190bfe6d="">植保无人机</td>
          <td data-v-190bfe6d="" class="">正常</td>
        </tr>
      </table>
    </div>
    <div class="box">
      <div class="title">
        采购动态监测
      </div>
      <table data-v-190bfe6d="" border="1" class="baseTable">
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">采购日期</td>
          <td data-v-190bfe6d="">采购物品</td>
          <td data-v-190bfe6d="">数量</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">2020.9.18</td>
          <td data-v-190bfe6d="">采购有机肥</td>
          <td data-v-190bfe6d="">50袋</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">2020.7.19</td>
          <td data-v-190bfe6d="">采购农事工具</td>
          <td data-v-190bfe6d="">20套</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">2020.5.28</td>
          <td data-v-190bfe6d="">采购植保器具</td>
          <td data-v-190bfe6d="">10套</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">2020.4.17</td>
          <td data-v-190bfe6d="">采购杀虫板</td>
          <td data-v-190bfe6d="">100套</td>
        </tr>
        <tr data-v-190bfe6d="">
          <td data-v-190bfe6d="">2020.4.17</td>
          <td data-v-190bfe6d="">采购诱虫灯</td>
          <td data-v-190bfe6d="">100套</td>
        </tr>
      </table>
    </div>
    <div class="box">
      <div class="title">
        历年销量及销售额统计
      </div>
      <div class="statistics-box">
        <statistics />
      </div>
    </div>
    <div class="box">
      <div class="title">
        质量安全检测
      </div>
      <div class="Roulette">
         <div class="Roulette-box">
            <div>本月指数:<span>0.3% ↑</span></div>
            <div>上月指数:99.10%</div>
         </div>
         <div class="Roulette-title">
             <span class="Roulette-info">溯源面积:<span class="Roulette-color">1000亩</span></span>
             <span>投入品监管农药网店:<span class="Roulette-color">40个</span></span>
         </div>   
      </div>
    </div>
    <div class="box">
      <div class="title">
        仓库利用率分析
      </div>
      <div class="Warehouse">
          <div class="Warehouse-list">
              <img src="@/assets/images/80%.png" alt="">
              <div class="item-bottom">
                  <p>仓位1</p>
                  <p>容量:200吨</p>
                  <p>总进仓量:100吨</p>
                  <p>总出仓量:95吨</p>
              </div>
          </div>
          <div class="Warehouse-list">
              <img src="@/assets/images/0%.png" alt="">
              <div class="item-bottom">
                  <p>仓位2</p>
                  <p>容量:200吨</p>
                  <p>总进仓量:0吨</p>
                  <p>总出仓量:0吨</p>
              </div>
          </div>
          <div class="Warehouse-list">
              <img src="@/assets/images/0%.png" alt="">
              <div class="item-bottom">
                  <p>仓位3</p>
                  <p>容量:200吨</p>
                  <p>总进仓量:0吨</p>
                  <p>总出仓量:0吨</p>
              </div>
          </div>
          <div class="Warehouse-list">
              <img src="@/assets/images/0%.png" alt="">
              <div class="item-bottom">
                  <p>仓位4</p>
                  <p>容量:200吨</p>
                  <p>总进仓量:0吨</p>
                  <p>总出仓量:0吨</p>
              </div>
          </div>
      </div>
    </div>
    <div class="box">
      <div class="title">
        生产加工监测
      </div>
      <div class="video-box">
         <video id="videojs" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="none">
         </video>
      </div>
    </div>
    <div class="box">
      <div class="title">
        仓储实时监测
      </div>
      <div class="box-8">
          <div class="box-8-list">
              <div class="box-8-list1">
                  <img src="../../../assets/images/cangku.png" alt="">
              </div>
              <div class="box-8-list2">
                  <p>进仓:<span>0.2吨</span></p>
                  <p>出仓:<span>0.5吨</span></p>
                  <p>当前存量:<span>9吨</span></p>
              </div>
          </div>
          <div class="box-8-list">
               <div class="box-8-list1">
                  <img src="../../../assets/images/cangku.png" alt="">
              </div>
              <div class="box-8-list2">
                  <p>进仓:<span>0.2吨</span></p>
                  <p>出仓:<span>0.5吨</span></p>
                  <p>当前存量:<span>9吨</span></p>
              </div>
          </div>
          <div class="box-8-list">
               <div class="box-8-list1">
                  <img src="../../../assets/images/cangku.png" alt="">
              </div>
              <div class="box-8-list2">
                  <p>进仓:<span>0.2吨</span></p>
                  <p>出仓:<span>0.5吨</span></p>
                  <p>当前存量:<span>9吨</span></p>
              </div>
          </div>
          <div class="box-8-list">
               <div class="box-8-list1">
                  <img src="../../../assets/images/cangku.png" alt="">
              </div>
              <div class="box-8-list2">
                  <p>进仓:<span>0.2吨</span></p>
                  <p>出仓:<span>0.5吨</span></p>
                  <p>当前存量:<span>9吨</span></p>
              </div>
          </div>
      </div>
    </div>
    <div class="box">
      <div class="title">
        茶叶销量品类分布
      </div>
      <div class="sale-box">
        <sale style="width:100%;height:100%" />
      </div>
    </div>
  </div>
</template>

<script>
import Statistics from ".././teaCompany/Statistics";
import sale from ".././teaCompany/sale";
import Video from 'video.js'
import 'video.js/dist/video-js.css'
export default {
  name: "container",
  components: {Statistics,sale
  },
  data() {
      return{
          myPlayer: {}
      }
  },
  mounted() {
	this.myPlayer = Video('videojs', {
	 		//确定播放器是否具有用户可以与之交互的控件。没有控件，启动视频播放的唯一方法是使用autoplay属性或通过Player API。
	         controls: true,
	         //自动播放属性,muted:静音播放
	         muted: true,
	         autoplay: true,
	         //建议浏览器是否应在<video>加载元素后立即开始下载视频数据。
	         preload: "auto",
	         //设置视频播放器的显示宽度（以像素为单位）
	         width: "280%",
	         //设置视频播放器的显示高度（以像素为单位）
	         height: "160%",
	         // url
	         // poster: 'https://static.shuxuejia.com/img/video_image.png', // 封面图片
	         sources: [{
	           src: 'https://cmgw-vpc.lechange.com:8890/LCO/7F07E5FPAGFC29D/0/0/20211006T022223/0d4b8eea9b2a66ad3e522b741151ab2a.m3u8?proto=https'
	         }],
	        //  playbackRates: [0.5, 1, 1.5, 2] //倍速播放
          reflush:true,
	
	       }, function onPlayerReady() {
	        //    Video.log('Your player is ready!'); // 比如： 播放量+1请求
	
	           this.on('ended', function() {
	           	// Video.log('Awww...over so soon?!');
	           });
	       });
},
  methods: {},
  beforeDestroy() {
    this.myPlayer.dispose()
  }
};
</script>
<style lang="scss" scoped>
.container {
  width: 90%;
  height: 90%;
  margin: 4% 10% 6% 0;
  display: flex;
  flex-wrap: wrap;
  align-content: space-between;
  justify-content: space-between;
  .box {
    width: 30%;
    height: 31%;
    background: url(../../../assets/images/border_02.png) 0 0 no-repeat;
    background-size: 100%;
    position: relative;
    .statistics-box {
      width: 100%;
      height: 105%;
      position: absolute;
      left: 0;
      top: 10%;
    }
    .title {
      text-align: center;
      margin-top: 7px;
    }
    .Roulette {
        height: 80%;
        margin-top: 15px;
        background: url(../../../assets/images/zjbiao.png) 0 0 no-repeat;
        background-size: 85%;
        position: relative;
        .Roulette-box {
            position: absolute;
            top: 27%;
            left: 50%;
            width: 37%;
            height: 27%;
            color: #0efcff;
            border: 0.5px solid hsla(0, 0%, 100%, 0.25);
            div {
                margin: 3px 5px;
                span {
                    color: rgb(247, 4, 4);
                }
            }
            
        }
        .Roulette-title {
            position: absolute;
            bottom: 10px;
            left: 10%;
            width: 80%;
            line-height: 25px;
            color: #0efcff;
            background-color: rgb(15,49,82);
            font-size: 8px;
            span {
                margin: 0 3px;
                text-align: center;
            }
            
        }
    }
  }
}
.baseTable {
  width: 70%;
  height: 65%;
  margin: 8% 15% 0 15%;
  text-align: center;
  color: #0efcff;
  border: 0.5px solid hsla(0, 0%, 100%, 0.25);
}
table {
  border-collapse: collapse;
  border-spacing: 0;
}
.Roulette-color {
    color: rgb(255, 255, 255);
}
.Warehouse {
    display: flex;
    height: 75%;
    width: 85%;
    margin: 15px 7.5% 0 7.5%;
    .Warehouse-list {
        flex: 1;
        margin: 0 5px;
        background-color: rgb(15,49,82);
        img {
            width: 100%;
        }
        .item-bottom {
            color: #21abfc;
            font-size: 1px;
            text-align: center;
        }
    }
}
.box-8 {
    display: flex;
    width: 85%;
    height: 77%;
    margin: 5% 7.5% 0 7.5%;
    flex-wrap: wrap;
    .box-8-list {
        display: flex;
        width: 48%;
        height: 45%;
        margin: 2.5% 1%;
        .box-8-list1 {
            flex: 2;
            img {
                margin-top: 10px;
                width:100%;
            }
        }
        .box-8-list2 {
            flex: 3;
            margin-left: 5px;
            p {
                line-height: 9px;
                color: #0efcff;
                span {
                    color: rgb(255, 255, 255);
                }
            }
        }
    }
}
.video-box {
    width: 100%;
    height: 100%;
    margin: 15px 25px;
}
.details {
  position: relative;
   font-size: 1em;
   line-height: .35em;
   font-weight: 100;
   span {
     color: rgb(255, 255, 255);
   }
    .details-img {
      position: absolute;
      top: 15px;
      left: 0;
      img {
        width: 30%;
        margin: 5px 0 0 15px;
      }
    }
    .details-title {
      color: #0efcff;
      padding-top: 10px;
      padding-left: 15px;
      .title-left {
        margin-left: 35%;
       
      }
      .location {
        color: #0efcff;
        margin-left: 8px;
      }
      .location-bottom {
        margin-left: 44px;
      }
      .text {
        line-height: 1.2em;
      }
    }
}
.sale-box {
  position: absolute;
  top: 35px;
  width: 100%;
  height: 90%;
}
</style>
