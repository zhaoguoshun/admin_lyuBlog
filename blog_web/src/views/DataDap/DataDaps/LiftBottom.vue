<template>
    <div class="bottom">
        <el-row>
            <el-button type="success" size="mini">正常</el-button>
            <el-button type="warning" size="mini">警告</el-button>
            <el-button type="danger" size="mini">故障</el-button>
        </el-row>
        <dv-capsule-chart :config="config" style="width:320px;height:170px" />
    </div>
</template>

<script>
export default {
  name: "LiftBottom",
  data() {
    return {
        config:{
            data: [
    {
      name: '故障',
      value: 2
    },
    {
      name: '警告',
      value: 4
    },
    {
      name: '正常',
      value: 8
    },
  ],
  colors: [ '#f54c4c', '#dfdb09c0', '#0dbb55c0'],
  
  unit: '单位',
  showValue: true
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
.bottom {
    padding: 15px 0 10px 30px;
}
.el-row {
    padding-left: 50px;
}
</style>