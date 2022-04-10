<template>
  <div id="data-view">
    <dv-full-screen-container>
      <top-header />
       <div class="main-content">
         <el-row class="main-content-row">
            <el-col :span="6">
              <div class="main-content-left">
                  <div class="left-top">
                      <div class="left-title">设备监测情况</div>
                        <lift-sector />
                  </div>
                  <div class="left-content">
                    <div class="left-title">环境监测情况</div>
                        <lift-board />
                  </div>
                  <div class="left-bottom">
                    <div class="left-title">安防监测情况</div>
                        <lift-bottom />
                  </div>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="main-content-content">
                <div class="content-content">
                    <device-map /> 
                </div>
                <div class="content-bottom">
                    <information />
                </div>
              </div>
            </el-col>
            <el-col :span="6" class="main-content-right">
              <right-data />
            </el-col>
          </el-row>
       </div>
    </dv-full-screen-container>
  </div>
</template>

<script>
import topHeader from "./DataDaps/topHeader";
import LiftSector from "./DataDaps/LiftSector";
import LiftBoard from "./DataDaps/LiftBoard";
import LiftBottom from "./DataDaps/LiftBottom";
import Information from "./DataDaps/Information";
import rightData from "./DataDaps/rightData";
import DeviceMap from "./DataDaps/DeviceMap";
  export default {
    name: "DataDap",
    components: {
     topHeader,LiftSector,LiftBoard,LiftBottom,Information,rightData,DeviceMap
    },
    data() {
      return {
        
      };
    },
    mounted() {

    },
    created() {
    
  },
    methods: {
     
    },
};
</script>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}
#data-view {
  width: 100%;
  height: 100%;
  color: #fff;
    }
#dv-full-screen-container {
    background: url(../../assets/Dscreen.png) no-repeat top center;
    background-size: 100% 100%;
    display: flex;
    flex-direction: column;
  }
.main-content {
  height: 100%;
  .main-content-row {
    height: 100%;
    .el-col {
      height: 100% !important;
      display: flex !important;
      .main-content-left {
        height: 100%;
        display: flex;
        flex: 1;
        flex-direction: column;
      }
      .left-top {
        flex: 1;
        .lift-sector {
          height: 100%;
        }
      }
      .left-content {
        flex: 1;
      }
      .left-bottom {
        flex: 1;
      }
    }
  }
}
.left-title {
          padding: 5px 0 10px 0;
          margin-left: 40px;
          width: 50%;
          font-size: 24px;
          color: rgb(205, 207, 204);
          border-bottom:2px solid rgb(205, 207, 204);
        }
.main-content-content {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  border-left:3px dotted #939492;
  border-right:3px dotted #939492;
  .content-content {
    flex: 3;
   
  }
  .content-bottom {
    flex: 1;
  }
}
</style>
