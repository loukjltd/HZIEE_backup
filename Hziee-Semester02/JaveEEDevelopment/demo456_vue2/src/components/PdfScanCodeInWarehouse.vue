<template>
  <div>
    <el-container>
      <el-header>
        <div style="width: 100%; font-size: 24px"><b>开始扫码</b></div>
        <el-row :gutter="8">
          <el-col :span="12">
            <el-input style="width:100%" v-model="input" type="text" placeholder="请输入内容"></el-input>
          </el-col>
          <el-col :span="8">
            <el-button type="primary" v-on:click="scanCode">扫码</el-button>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <div style="width: 100%; font-size: 24px"><b>扫入列表</b></div>
        <ul>
          <li  v-for="section in pdfScanCodeList" v-bind:key="section">
            <p>{{section.pdaCode}}</p>
            <p>{{section.trayCode}}</p>
          </li>
        </ul>
      </el-main>
      <el-footer>
        <el-row>
          <el-col :span="12">
            <div style="width: 100%; font-size: 24px"><b>扫入卷数</b></div>
          </el-col>
          <el-col :span="8">
            <el-button type="primary" v-on:click="commitScanCodeList">提交</el-button>
          </el-col>
        </el-row>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import {LoadingPdfTrayCodes, scanATrayCode} from "@/util/api";

export default {
  name: "PdfScanCodeInWarehouse",
  data () {
    return {
      pdfScanCodeList: [],
      input: 'abcde'
    }
  },
  mounted(){
    this.doLoadingPdfScanCodes()
  },

  methods:{
    scanCode:function (){
      let params = {
        trayCode:'ZT4C03140003',
        currentWhId:5,
        currentFstId:4,
        currentPdaCode:'FC',
        loginId: 1262,
        scanId: 1001
      }
      console.log(params)
      scanATrayCode(params).then((res)=>{
        console.log("--------")
        console.log(res)
        this.pdfScanCodeList = res
        this.input = res.trayCode;

        console.log("--------")
      })
    },
    commitScanCodeList:function (){
      alert('调用了提交函数')
    },

    doLoadingPdfScanCodes: function (){
      let params = {
        fstId:4,
        whId:5,
        scanId:1001,
        createPerson:1262,
        pdaCode: 'FC'
      }
      console.log(params)
      LoadingPdfTrayCodes(params).then((res)=>{
        console.log("--------")
        console.log(res)
        this.pdfScanCodeList = res
        console.log("--------")
      })
    }
  }
}
</script>

<style scoped>

</style>