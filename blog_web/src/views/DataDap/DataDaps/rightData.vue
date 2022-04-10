<template>
    <div class="right">
        <div class="right-top">
            <div class="title">智慧路灯</div>
                <div class="right-top-box">
                   <div v-for="(item, i ) in boxdata " :key="i" class="databox"> 
                    <div>{{item.toptit}}</div>
                    <img :src="item.img" alt="">
                    <div>正常:<span>{{item.normal}}</span></div>
                    <div>异常:<span>{{item.abnormal}}</span></div> 
                   </div> 
                </div>  
        </div>
        <div class="right-cen">
            <div class="title">智能垃圾箱</div>
            <div class="right-right-box">
                <div class="databox"> 
                    <div>{{dustbin[0].toptit}}</div>
                    <img :src="dustbin[0].img" alt="">
                    <div>空桶数:<span>{{dustbin[0].normal}}</span></div>
                    <div>满桶数:<span>{{dustbin[0].abnormal}}</span></div> 
                   </div> 
                <div class="databox"> 
                    <div>{{dustbin[1].toptit}}</div>
                    <img :src="dustbin[1].img" alt="">
                    <div>异常数:<span>{{dustbin[1].normal}}</span></div>
                    <div>正常数:<span>{{dustbin[1].abnormal}}</span></div> 
                </div> 
            </div>
        </div>
        <div class="right-bittom">
            <div class="title">无桩充电</div>
            <div class="right-bittom-box">
                <div class="databox bottom-box"> 
                    <img src="../../../assets/dpimg/cd.png" alt="">
                    <div class="bottom-title">当日充电次数</div>
                    <div><span>3</span>次</div> 
                   </div> 
                <div class="databox bottom-box"> 
                   
                    <img src="../../../assets/dpimg/dl.png" alt="">
                    <div class="bottom-title">当日充电电量</div>
                    <div><span>1.00</span>kwh</div> 
                </div> 
            </div>
        </div>
    </div>
</template>
<script>
    export default {
  name: "Information",
  data() {
    return {
        boxdata:[
            {
                toptit:'路灯照明',
                img:require('../../../assets/dpimg/dd.png'),
                normal: 2,
                abnormal: 0,
            },
             {
                toptit:'PM2.5',
                img:require('../../../assets/dpimg/2.5.png'),
                normal: 2,
                abnormal: 0,
            },
             {
                toptit:'温度计',
                img:require('../../../assets/dpimg/wd.png'),
                normal: 2,
                abnormal: 0,
            },
             {
                toptit:'湿度计',
                img:require('../../../assets/dpimg/sd.png'),
                normal: 2,
                abnormal: 0,
            },
        ],
        dustbin:[
            {
                toptit:'空桶/满桶',
                img:require('../../../assets/dpimg/ljx.png'),
                normal: 4,
                abnormal: 0,
            },
             {
                toptit:'桶内温度',
                img:require('../../../assets/dpimg/ljwd.png'),
                normal: 4,
                abnormal: 0,
            },
        ],
    }
  },
  mounted(){
  },
  methods: {

  }
}
</script>

<style scoped>
.right {
    display: flex;
    width: 100%;
    flex-direction: column;
}
.right div {
    flex: 1;
}
.title {
         padding: 5px 0 10px 0;
          margin-left: 15px;
          width: 50%;
          font-size: 24px;
          color: rgb(205, 207, 204);
          border-bottom:2px solid rgb(205, 207, 204);
}
.right-top-box {
    display: flex;
    height: 100%;
    margin: 0 15px;
}
.right-right-box {
    display: flex;
}
.right-bittom-box {
    display: flex;
}
.databox {
    flex: 1;
    text-align: center;
    line-height: 1.5em;
    font-size: 18px;
    font-weight: bold; 
    color: rgb(205, 207, 204);
    margin-top: 20px;
}
.databox img {
    width: 75px;
}
.databox div span {
    color: rgb(251, 255, 0);
}
.bottom-title {
    width: 80%;
    border-bottom:2px solid rgb(205, 207, 204);
}
.bottom-box {
    text-align: left;
    margin-left: 20px;
}
</style>