<template>
  <div>
    <el-container>
      <el-header>
        <el-row :gutter="10">
          <el-col :span="16">
            <el-input style="width:80%" v-model="input" type="text" placeholder="请输入内容"></el-input>
          </el-col>
          <el-col :span="4">
            <el-button type="primary" v-on:click="scanCode">扫码</el-button>
          </el-col>
        </el-row>
      </el-header>
      <el-main>Main
        <ul>
          <li v-for="section in pdfScanCodeList" v-bind:key="section">
            <p>{{ section.pdaCode }}</p>
            <p>{{ section.trayCode }}</p>
          </li>
          <!--          <el-button type="primary" v-on:click="doLoadingPdfScanCode">查询</el-button>-->
        </ul>
      </el-main>
      <el-footer>
        <el-row>
          <el-col :span="16">
            <div style="width:80%">扫入卷数</div>
          </el-col>
          <el-col :span="4">
            <el-button type="primary" v-on:click="commitScanCodeList">提交</el-button>
          </el-col>
        </el-row>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import {LoadingPdfTrayCodes, ScanATrayCode, CommitTrayCodeList} from "@/util/api";

export default {
  name: "PdfScanCodeInWarehouse",
  data() {
    return {
      pdfScanCodeList: [],
      input: 'abcde',
      pdfTrayCode: ''
    }
  },
  mounted() {
    this.doLoadingPdfScanCode()
  },
  methods: {
    scanCode: function () {
      //alert('调用了扫码函数')
      let params = {
        trayCode: 'ZT4C03140003',
        currentWhId: 5,
        currentFstId: 4,
        currentPdaCode: 'Fc',
        loginId: 1262,
        scanId: 1001

      }
      console.log(params)
      ScanATrayCode(params).then((res) => {
        console.log("---------")
        console.log(res)
        this.pdfScanCodeList = res
        // this.pdfScanCodeList.result = res
        this.input = res.trayCode
        console.log("-------")
      })
    },

    commitScanCodeList: function () {
      let params = {
        currentWhId: 5,
        currentFstId: 4,
        currentPdaCode: 'Fc',
        loginId: 1262,
        scanId: 1001
      }
      console.log(params)
      CommitTrayCodeList(params).then((res) => {
        console.log("---------")
        console.log(res)
        console.log("-------")
      })
      //alert('提交了卷数')
    },

    doLoadingPdfScanCode: function () {
      let params = {
        fstId: 4,
        whId: 5,
        scanId: 1001,
        createPerson: 1262,
        pdaCode: 'FC'
      }
      console.log(params)
      LoadingPdfTrayCodes(params).then((res) => {
        console.log("---------")
        console.log(res)
        this.pdfScanCodeList = res
        // this.pdfScanCodeList.result = res
        console.log("-------")
      })
    }

  }
}
</script>

<style scoped>

</style>