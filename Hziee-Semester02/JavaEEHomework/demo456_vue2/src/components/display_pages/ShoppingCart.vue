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
          <router-link to="/ShoppingCart"><b>购物车</b></router-link>
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
      <p>以下是已经添加到购物车的商品</p>
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
            <td class="foodOperation"><b>操作</b></td>
          </tr>
          <tr v-for="item in shoppingCartList" :key="item">
            <td class="rankNum">{{ item.dingId }}</td>
            <td class="foodName">{{ item.cai }}</td>
            <td class="foodPrice">{{ item.caiJG }}</td>
            <td class="foodQuantity">{{ item.caiPinShuLiang }}</td>
            <td class="foodOperation">
              <div class="addButton">
                <a href="#" v-on:click="doAddOrMinusFoodQuantity(item.caiId, 1)">+</a>
              </div>
              <br>
              <div class="minusButton">
                <a href="#" v-on:click="doAddOrMinusFoodQuantity(item.caiId, 0)">-</a>
              </div>
            </td>
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
import {
  DoAddOrMinusFoodQuantity,
  DoLoadShoppingCartData,
} from "@/util/api";

export default {
  name: "ShoppingCart",

  data() {
    return {
      shoppingCartList: [],
      requestFoodName: [],
    }
  },

  mounted() {
    this.doLoadShoppingCartData();
  },

  methods: {

    doLoadShoppingCartData: function() {
      let testParams = {
        //
      }
      DoLoadShoppingCartData(testParams).then(res => {this.shoppingCartList = res;});
    },

    doAddOrMinusFoodQuantity: function(foodId, quantityStatus) {
      let testParams = {
        caiId: foodId,
        status: quantityStatus,
      };
      DoAddOrMinusFoodQuantity(testParams).then(res => {this.requestFoodName = res;});
      if (quantityStatus === 1) {
        alert("已增加1份！");
        this.doLoadShoppingCartData();
        this.doLoadShoppingCartData();
        this.doLoadShoppingCartData();
      } else if(quantityStatus === 0) {
        alert("已减少1份！");
        this.doLoadShoppingCartData();
        this.doLoadShoppingCartData();
        this.doLoadShoppingCartData();
      }
    },



  }
}
</script>

<style scoped>

</style>