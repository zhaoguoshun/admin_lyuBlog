<template>
    <div class="mation">
        <div class="mation-top">
            <span class="activation">警告信息</span>
            <span class="activation">丨</span>
            <span>运维信息</span>
        </div>
        <div class="mation-bottom">
            <span>事件时间</span>
            <span>电器名称</span>
            <span>事件类型</span>
            <span>事件状态</span>
            <span>处理标志</span>
        </div>
    </div>
</template>
<script>
  export default {
  name: "Information",
  data() {
    return {
        
    }
  },
  mounted(){
  },
  methods: {

  }

};
</script>
<style scoped>
span {
    display: inline-block;
    line-height: 1.5em;
}
.mation {
 color: #c8c9c8;
}
.mation-top {
    font-size: 24px;
    text-align: center;
    margin: 0 auto;
}
.activation {
    color: #70a5ba;
}
.mation-bottom {
    display: flex;
    background-color: #0272a7;
    margin: 0 30px;
}
.mation-bottom span {
    flex: 1;
    text-align: center;
    margin: 0 auto;
    font-size: 18px;
}
</style>