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
      <p>您的订单已提交</p>
    </div>

    <div id="orderInfo">
      <div id="otherInfo">
        <ul>
          <li><a class="nonClickable"><b>请选择付款方式</b></a></li>
          <li><a class="alipay">支付宝</a></li>
          <br>
          <li><a class="wechat">微信支付</a></li>
          <br>
          <br>
          <li><a class="nonClickable"><b>是否完成?</b></a></li>
          <li>
            <a class="payStatus" v-on:click="showPayInfo">未完成</a>
          </li>
          <br>
          <li>
            <router-link to="/DisplayFinishedOrders" class="payStatus">已完成</router-link>
          </li>
          <br>
          <br>
        </ul>
      </div>

      <div id="qrCode">
        <img src="../../assets/Alipay.png">
        <img src="../../assets/WeChatPay.png">
      </div>
    </div>

  </div>
</template>
<style>
@import "../using_css/CommonStyleSheet.css";
@import "../using_css/FinishedOrder.css";
</style>

<script>
export default {
  name: "FinishedOrder",
  data() {
    return {
      //
    }
  },
  methods: {
    showPayInfo: function () {
      alert("请先付款！");
    }
  },
}


</script>

<style scoped>

</style>