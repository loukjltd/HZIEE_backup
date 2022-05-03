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
          <router-link to="/MenuList"><b>菜单</b></router-link>
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
      <p>请选择你想要吃的东西，完成后可点击购物差查看</p>
    </div>

    <div id="orderPart">
      <div id="otherInfo">
        <ul>
          <li><a href="#hot_sale">人气热卖</a></li>
          <li><a href="#single">单人餐</a></li>
          <li><a href="#multi">多人餐</a></li>
          <li><a href="#">全鸡</a></li>
          <li><a href="#">炸鸡小食</a></li>
          <li><a href="#">汉堡卷</a></li>
          <li><a href="#">米饭</a></li>
          <li><a href="#">饮品</a></li>
          <li><a href="#">咖啡</a></li>
          <li><a href="#">配餐</a></li>
          <li><a href="#">蛋挞烘焙</a></li>
          <li><a href="#">冰淇淋</a></li>
          <li><a href="#">儿童餐</a></li>
          <li><a href="#">自在厨房</a></li>
        </ul>
      </div>

      <div id="foodDetails">
        <ul>
          <li>
            <p class="sub_title" id="hot_sale">人气热卖</p>
            <ul>
              <li>
                <img src="../../assets/FoodImage_01.jpeg" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_02.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>
          <li>
            <p class="sub_title" id="single">单人餐</p>
            <ul>
              <li>
                <img src="../../assets/FoodImage_03.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_04.jpeg" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_05.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_06.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_07.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>


          <li>
            <p class="sub_title" id="multi">双人餐</p>
            <ul>
              <li>
                <img src="../../assets/FoodImage_08.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_09.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_10.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_11.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_12.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
              <li>
                <img src="../../assets/FoodImage_13.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>Sides Lovers 8 pc. Chicken Meal</p>
                  <p>卡路里：2580-5640千卡</p>
                  <p>价格：¥49.99</p>
                  <br>
                  <a href="#">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<style>
@import "../using_css/CommonStyleSheet.css";
@import "../using_css/MenuList.css";
</style>

<script>
export default {
  name: "MenuList"
}
</script>

<style scoped>

</style>