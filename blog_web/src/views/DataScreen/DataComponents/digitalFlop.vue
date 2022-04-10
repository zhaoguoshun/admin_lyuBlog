<template>
  <div id="digital-flop">
    <div
      class="digital-flop-item"
      v-for="item in digitalFlopData"
      :key="item.title"
    >
      <dv-border-box-8 class="lh"></dv-border-box-8>
      <div class="digital-flop-title">{{ item.title }}</div>
      <div class="digital-flop">
        <div
          class="icon"
          style="background: #00C2FF;border: 0.05rem solid #00C2FF;"
        >
          <img :src="item.icon" alt="" />
        </div>
        <dv-digital-flop
          :config="item.number"
          style="width:1rem;height:.5rem;font-size:.16rem"
        />
        <div class="unit">{{ item.unit }}</div>
      </div>
    </div>
    <dv-decoration-10 />
  </div>
</template>

<script>
export default {
  name: "DigitalFlop",
  props: ["enterpriseInfo"],
  data() {
    return {
      digitalFlopData: []
    };
  },
  methods: {
    createData() {
      const { randomExtend } = this;
      this.digitalFlopData = [
        {
          title: "员工总人数",
          icon: require("../../../assets/dataImg/楼.png"),
          number: {
            number: [this.enterpriseInfo.personCount],
            content: "{nt}",
            textAlign: "right",
            style: {
              fill: "#4d99fc",
              fontWeight: "bold"
            }
          },
          unit: "个"
        },
        {
          title: "今日识别员工次数",
          icon: require("../../../assets/dataImg/个人中心.png"),
          number: {
            number: [this.enterpriseInfo.todayPerson],
            content: "{nt}",
            textAlign: "right",
            style: {
              fill: "#f46827",
              fontWeight: "bold"
            }
          },
          unit: "个"
        },
        {
          title: "今日识别访客次数",
          icon: require("../../../assets/dataImg/好友.png"),
          number: {
            number: [this.enterpriseInfo.todayVisitor],
            content: "{nt}",
            textAlign: "right",
            style: {
              fill: "#40faee",
              fontWeight: "bold"
            }
          },
          unit: "个"
        },
        {
          title: "今日识别陌生次数",
          icon: require("../../../assets/dataImg/客服.png"),
          number: {
            number: [this.enterpriseInfo.todayStranger],
            content: "{nt}",
            textAlign: "right",
            style: {
              fill: "#4d99fc",
              fontWeight: "bold"
            }
          },
          unit: "个"
        },
        {
          title: "体温异常次数",
          icon: require("../../../assets/dataImg/标签.png"),
          number: {
            number: [this.enterpriseInfo.tempExceptionCount],
            content: "{nt}",
            textAlign: "right",
            style: {
              fill: "#40faee",
              fontWeight: "bold"
            }
          },
          unit: "个"
        },
        {
          title: "设备总数",
          icon: require("../../../assets/dataImg/扫一扫.png"),
          number: {
            number: [this.enterpriseInfo.deviceCount],
            content: "{nt}",
            textAlign: "right",
            style: {
              fill: "#f46827",
              fontWeight: "bold"
            }
          },
          unit: "个"
        },
        {
          title: "在线设备数",
          icon: require("../../../assets/dataImg/手机.png"),
          number: {
            number: [this.enterpriseInfo.deviceOnlineCount],
            content: "{nt}",
            textAlign: "right",
            style: {
              fill: "#40faee",
              fontWeight: "bold"
            }
          },
          unit: "个"
        }
      ];
    },
    randomExtend(minNum, maxNum) {
      if (arguments.length === 1) {
        return parseInt(Math.random() * minNum + 1, 10);
      } else {
        return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10);
      }
    }
  },
  mounted() {
    const { createData } = this;

    let _that = this;
    let interval = setInterval(() => {
      if (_that.enterpriseInfo.todayPerson !== undefined) {
        createData();
        clearInterval(interval);
      }
    }, 200);
  },
  watch: {
    enterpriseInfo: {
      handler: function(newVal, oldVal) {
        this.createData();
      },
      deep: true
    }
  }
};
</script>

<style lang="scss">
#digital-flop {
  position: relative;
  height: 15%;
  flex-shrink: 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: rgba(6, 30, 93, 0.5);

  .dv-decoration-10 {
    position: absolute;
    width: 95%;
    left: 2.5%;
    height: 5px;
    bottom: 0px;
  }

  .digital-flop-item {
    position: relative;
    width: 14.286%;
    height: 80%;
    margin: 0 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background: rgba(6, 30, 93, 0.5);

    .lh {
      position: absolute;
      top: 0;
      height: 1.5px;
    }

    .digital-flop-title {
      font-size: 0.16rem;
      margin-bottom: 0.2rem;
    }

    .digital-flop {
      display: flex;
      .icon {
        position: relative;
        width: 0.4rem;
        height: 0.4rem;
        border-radius: 50%;
        img {
          position: absolute;
          width: 85%;
          height: 85%;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
        }
      }
    }
  }

  .unit {
    margin-left: 0.1rem;
    display: flex;
    align-items: flex-end;
    box-sizing: border-box;
    padding-bottom: 0.13rem;
    font-size: 0.12rem;
  }
}
</style>
