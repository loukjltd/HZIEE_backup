<template>
  <div>
    <div id="navBar">
      <ul>
        <li><a href="#" style="font-family: Impact, Helvetica, serif; font-size: 24px"><b>Kentucky Fried Chicken</b></a>
        </li>
        <li>
          <router-link to="/">开始点单</router-link>
        </li>
        <li>
          <router-link to="/MenuList">菜单</router-link>
        </li>
        <li>
          <router-link to="/ShoppingCart">购物车</router-link>
        </li>
        <li><a href="#">关于KFC</a></li>
        <li><a href="#">查找KFC</a></li>
        <li><a href="#">商城</a></li>
        <li>
          <router-link to="/FinishedOrder" id="finish_order">完成点单</router-link>
        </li>
      </ul>
    </div>
    <div id="mainTitle">
      <p>付款成功！</p>
    </div>
    <div id="orderInfo">
      <div id="otherInfo">
        <ul>
          <li><a><b>当前点餐人数</b></a></li>
          <li v-for="userInfo in shoppingCartList.slice(0, 1)" :key="userInfo">
            <a>{{ userInfo.yongHuRS }}人</a>
          </li>
          <br>
          <br>
          <li><a><b>当前点餐桌号</b></a></li>
          <li v-for="userInfo in shoppingCartList.slice(0, 1)" :key="userInfo">
            <a>{{ userInfo.wei }}</a>
          </li>
          <br>
          <br>
        </ul>
      </div>

      <div id="addedFood">
        <table>
          <tr>
            <td class="rankNum"><b>序号</b></td>
            <td class="foodName"><b>商品名称</b></td>
            <td class="foodPrice"><b>价格</b></td>
            <td class="foodQuantity"><b>数量</b></td>
            <td class="foodOperation"><b>状态</b></td>
          </tr>
          <tr v-for="item in specificTableInfo" :key="item">
            <td class="rankNum">{{ item.dingId }}</td>
            <td class="foodName">{{ item.cai }}</td>
            <td class="foodPrice">{{ item.caiJG }}</td>
            <td class="foodQuantity">{{ item.caiPinShuLiang }}</td>
            <td class="foodOperation">付款成功！</td>
          </tr>
          <tr>
            <td class="rankNum"></td>
            <td class="foodName"></td>
            <td class="foodPrice"></td>
            <td class="foodQuantity">总价：</td>
            <td class="foodOperation">¥499</td>
          </tr><tr>
            <td class="rankNum"></td>
            <td class="foodName"></td>
            <td class="foodPrice"></td>
            <td class="foodQuantity">数量：</td>
            <td class="foodOperation">50份</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<style>
@import "../using_css/CommonStyleSheet.css";
@import "../using_css/ShoppingCart.css";
</style>

<script>
import {DoLoadShoppingCartData, DoLoadUserInfo} from "@/util/api";
import global from "@/util/global";

export default {
  name: "ShoppingCart",

  data() {
    return {
      // userInfoList: [],
      shoppingCartList: [],
      requestFoodName: [],
      totalPrice: 0,
    }
  },

  mounted() {
    this.doLoadUserInfo();
    this.doLoadShoppingCartData();
    // this.doCalculateTotalPrice();
  },

  computed: {
    specificTableInfo: function () {
      let targetTableNum = this.userInfoList[0].dingId;
      return this.shoppingCartList.filter(tableNum => tableNum.dingId === targetTableNum);
    }
  },

  methods: {
    doLoadUserInfo: function() {
      DoLoadUserInfo().then(res => {this.userInfoList = res;});
    },

    doLoadShoppingCartData: function() {
      DoLoadShoppingCartData().then(res => {this.shoppingCartList = res;});
      global.presentOrderNumber = "";
      console.log(global.presentOrderNumber);
    },

    // doCalculateTotalPrice: function() {
    //   DoCalculateTotalPrice().then(res => {this.totalPrice = res;});
    // }

  }
}
</script>

<style scoped>

</style>