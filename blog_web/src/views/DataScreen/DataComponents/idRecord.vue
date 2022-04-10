<template>
  <div id="idRecord">
    <div class="rtitle">
      <div>最近识别记录</div>
    </div>
    <div style="width:100%;overflow: hidden;">
      <div class="rmain" :style="{ marginLeft: wix + 'rem' }">
        <div class="figure" v-for="item in meetingRecordData" :key="item.id">
          <img :src="handleOssUrl(item.imgBase64)" alt="" />
          <div>{{ item.name }}</div>
          <div class="time">{{ handleDate(item.recordTime) }}</div>
          <div class="firm" :title="handleJson(item.xs)">
            {{ handleJson(item.xs) }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Cards",
    props: ['meetingRecordData'],
    data() {
      return {
        cards: [
          {
            id: "1",
            url: require("../../../assets/ren1.jpg"),
            name: "张三",
            time: "19:45:35",
            film: "盛开互动"
          },
          {
            id: "2",
            url: require("../../../assets/ren2.jpg"),
            name: "李四",
            time: "19:54:52",
            film: "北环产业园"
          },
          {
            id: "3",
            url: require("../../../assets/ren1.jpg"),
            name: "张三",
            time: "19:45:35",
            film: "盛开互动"
          },
          {
            id: "4",
            url: require("../../../assets/ren2.jpg"),
            name: "李四",
            time: "19:54:52",
            film: "北环产业园"
          },
          {
            id: "5",
            url: require("../../../assets/ren1.jpg"),
            name: "张三",
            time: "19:45:35",
            film: "盛开互动"
          },
          {
            id: "6",
            url: require("../../../assets/ren2.jpg"),
            name: "李四",
            time: "19:54:52",
            film: "北环产业园"
          },
          {
            id: "7",
            url: require("../../../assets/ren1.jpg"),
            name: "张三",
            time: "19:45:35",
            film: "盛开互动"
          },
          {
            id: "8",
            url: require("../../../assets/ren2.jpg"),
            name: "李四",
            time: "19:54:52",
            film: "北环产业园"
          },
          {
            id: "9",
            url: require("../../../assets/ren1.jpg"),
            name: "张三",
            time: "19:45:35",
            film: "盛开互动"
          },
          {
            id: "10",
            url: require("../../../assets/ren2.jpg"),
            name: "李四",
            time: "19:54:52",
            film: "北环产业园"
          }
          // {id:'12',url:'https://s4.aconvert.com/convert/p3r68-cdx67/a93n9-li8ik.jpg',name:'赵六',time:'19:54:52',film:'北环产业园'},
        ],
        wix: 0,
        time: null, //用来清除定时器
        j: 0
      };
    },

    methods: {
      createData() {
      },
      moveImg(flag) {
      },
      handleOssUrl(url) {
        return this.$ossPre + url;
      },
      /**************************************时间格式化处理************************************/
      dateFormat(fmt, date) { //author: meizz
        let o = {
          "M+": date.getMonth() + 1,                 //月份
          "d+": date.getDate(),                    //日
          "h+": date.getHours(),                   //小时
          "m+": date.getMinutes(),                 //分
          "s+": date.getSeconds(),                 //秒
          "q+": Math.floor((date.getMonth() + 3) / 3), //季度
          "S": date.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
          fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (let k in o)
          if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
      },
      handleDate(dateStr) {

        return this.dateFormat('hh:mm:ss', new Date(dateStr));
      },
      handleJson(jsonStr) {
        if (this.isJSON(jsonStr)) {
          return JSON.parse(jsonStr).name;
        } else {
          return '';
        }
      },
      //是否为json
      isJSON(str) {
        if (typeof str == 'string') {
          try {
            let obj = JSON.parse(str);
            if (typeof obj == 'object' && obj) {
              return true;
            } else {
              return false;
            }
          } catch (e) {
            return false;
          }
        }
        console.log("It is not a string!");
      }
  },
  watch: {
    meetingRecordData: function(newValue, oldValue) {
      let i = 0.86;
      clearInterval(this.time);
      if (this.meetingRecordData.length > 10) {
        this.time = setInterval(() => {
          this.j += 0.01;
          this.wix += -0.01;
          if (this.j.toFixed(2) == i) {
            this.wix = 0;
            this.j = 0;
            this.meetingRecordData.shift();
            clearInterval(this.time);
          }
        });
      }
    }
  }
};
</script>

<style lang="scss" scoped>
#idRecord {
  width: 100%;
  height: 100%;
  // flex: 1;
  // background: rgba(6, 30, 93, 0.5);
  display: flex;
  flex-direction: column;
  padding: 5px;
  .rtitle {
    // width: 100%;
    position: relative;
    font-size: 0.14rem;
    font-weight: bold;
    height: 30px;
    line-height: 30px;
    padding-bottom: 5px;
    border-bottom: 2px solid rgba($color: #fff, $alpha: 0.3);
  }

  .rmain {
    position: absolute;
    // top: 1.22rem;
    // left: 50%;
    // transform: translate(-50%,-50%);
    height: auto;
    width: 9rem;
    margin: 0 auto;
    display: flex;
    padding: 10px;
    // flex-wrap: wrap;
    text-align: center;
    .figure {
      width: 0.8rem;
      height: 100%;
      display: flex;
      flex-direction: column;
      // height: auto;
      margin-right: 10px;
      margin-top: 0px;
      img {
        width: 0.8rem;
        height: 0.8rem;
        margin: 0 auto;
      }

      .time {
        font-size: 0.12rem;
      }

      .firm {
        font-size: 0.12rem;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      }
    }
  }
}
</style>
