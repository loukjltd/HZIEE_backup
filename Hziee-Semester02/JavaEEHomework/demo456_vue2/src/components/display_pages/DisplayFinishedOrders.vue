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
      <p>在这里你可以看到已经提交的订单</p>
    </div>

    <div id="orderInfo">
      <div id="otherInfo">
        <ul>
          <li><a><b>点餐人数</b></a></li>
          <li><a>2人</a></li>
          <br>
          <br>
          <li><a><b>点餐桌号</b></a></li>
          <li><a>B814</a></li>
          <br>
          <br>
        </ul>
      </div>

      <div id="addedFood">
        <table>
          <tr>
            <td class="rankNum"><b>序号</b></td>
            <td class="foodImage"><b>图片</b></td>
            <td class="foodName"><b>商品名称</b></td>
            <td class="foodPrice"><b>价格</b></td>
            <td class="foodQuantity"><b>数量</b></td>
            <td class="foodOperation"><b>序列号</b></td>
          </tr>
          <tr>
            <td class="rankNum">1</td>
            <td class="foodImage"><img src="../../assets/FoodImage_01.jpeg"></td>
            <td class="foodName">BucketForOne</td>
            <td class="foodPrice">¥49.99</td>
            <td class="foodQuantity">2</td>
            <td class="foodOperation">KFC202205010001</td>
          </tr>
          <tr>
            <td class="rankNum">2</td>
            <td class="foodImage"><img src="../../assets/FoodImage_01.jpeg"></td>
            <td class="foodName">BucketForOne</td>
            <td class="foodPrice">¥49.99</td>
            <td class="foodQuantity">2</td>
            <td class="foodOperation">KFC202205010002</td>
          </tr>
          <tr>
            <td class="rankNum">3</td>
            <td class="foodImage"><img src="../../assets/FoodImage_01.jpeg"></td>
            <td class="foodName">BucketForOne</td>
            <td class="foodPrice">¥49.99</td>
            <td class="foodQuantity">2</td>
            <td class="foodOperation">KFC202205010003</td>
          </tr>
          <tr>
            <td class="rankNum">4</td>
            <td class="foodImage"><img src="../../assets/FoodImage_01.jpeg"></td>
            <td class="foodName">BucketForOne</td>
            <td class="foodPrice">¥49.99</td>
            <td class="foodQuantity">2</td>
            <td class="foodOperation">KFC202205010004</td>
          </tr>
          <tr>
            <td class="rankNum">5</td>
            <td class="foodImage"><img src="../../assets/FoodImage_01.jpeg"></td>
            <td class="foodName">BucketForOne</td>
            <td class="foodPrice">¥49.99</td>
            <td class="foodQuantity">2</td>
            <td class="foodOperation">KFC202205010005</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<style>
@import "../using_css/CommonStyleSheet.css";
@import "../using_css/DisplayFinishedOrders.css";
</style>

<script>
export default {
  name: "DisplayFinishedOrders"
}
</script>

<style scoped>

</style>