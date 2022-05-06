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
      <p>请选择你想要吃的东西，完成后可点击购物车查看</p>
    </div>
    <div id="orderPart">
      <div id="otherInfo">
        <ul v-for="category in categoryList" :key="category">
          <li><a>{{ category.caiLei }}</a></li>
        </ul>
      </div>
      <div id="foodDetails">
        <ul>
          <li>
            <p class="sub_title" id="hotSales">人气热卖</p>
            <ul>
              <li v-for="hotSale in hotSales" :key="hotSale">
                <img src="../../assets/FoodImage_01.jpeg" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ hotSale.cai }}</p>
                  <p>菜品序号：{{ hotSale.caiId }}</p>
                  <p>菜品价格：¥{{ hotSale.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(hotSale.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>
          <li>
            <p class="sub_title" id="singleMeals">单人餐</p>
            <ul>
              <li v-for="singleMeal in singleMeals" :key="singleMeal">
                <img src="../../assets/FoodImage_02.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ singleMeal.cai }}</p>
                  <p>菜品序号：{{ singleMeal.caiId}}</p>
                  <p>菜品价格：¥{{ singleMeal.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(singleMeal.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>


          <li>
            <p class="sub_title" id="doubleMeals">双人餐</p>
            <ul>
              <li v-for="doubleMeal in doubleMeals" :key="doubleMeal">
                <img src="../../assets/FoodImage_03.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ doubleMeal.cai }}</p>
                  <p>菜品序号：{{ doubleMeal.caiId}}</p>
                  <p>菜品价格：¥{{ doubleMeal.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(doubleMeal.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="fullChickens">全鸡</p>
            <ul>
              <li v-for="fullChicken in fullChickens" :key="fullChicken">
                <img src="../../assets/FoodImage_04.jpeg" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ fullChicken.cai }}</p>
                  <p>菜品序号：{{ fullChicken.caiId}}</p>
                  <p>菜品价格：¥{{ fullChicken.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(fullChicken.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="friedChickens">炸鸡小食</p>
            <ul>
              <li v-for="friedChicken in friedChickens" :key="friedChicken">
                <img src="../../assets/FoodImage_05.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ friedChicken.cai }}</p>
                  <p>菜品序号：{{ friedChicken.caiId}}</p>
                  <p>菜品价格：¥{{ friedChicken.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(friedChicken.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="hamburgers">汉堡卷</p>
            <ul>
              <li v-for="hamburger in hamburgers" :key="hamburger">
                <img src="../../assets/FoodImage_06.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ hamburger.cai }}</p>
                  <p>菜品序号：{{ hamburger.caiId}}</p>
                  <p>菜品价格：¥{{ hamburger.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(hamburger.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="rices">米饭</p>
            <ul>
              <li v-for="rice in rices" :key="rice">
                <img src="../../assets/FoodImage_07.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ rice.cai }}</p>
                  <p>菜品序号：{{ rice.caiId}}</p>
                  <p>菜品价格：¥{{ rice.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(rice.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="drinks">饮品</p>
            <ul>
              <li v-for="drink in drinks" :key="drink">
                <img src="../../assets/FoodImage_08.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ drink.cai }}</p>
                  <p>菜品序号：{{ drink.caiId}}</p>
                  <p>菜品价格：¥{{ drink.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(drink.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="coffees">咖啡</p>
            <ul>
              <li v-for="coffee in coffees" :key="coffee">
                <img src="../../assets/FoodImage_09.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ coffee.cai }}</p>
                  <p>菜品序号：{{ coffee.caiId}}</p>
                  <p>菜品价格：¥{{ coffee.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(coffee.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="desserts">配餐</p>
            <ul>
              <li v-for="dessert in desserts" :key="dessert">
                <img src="../../assets/FoodImage_10.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ dessert.cai }}</p>
                  <p>菜品序号：{{ dessert.caiId}}</p>
                  <p>菜品价格：¥{{ dessert.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(dessert.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="bakes">蛋挞烘焙</p>
            <ul>
              <li v-for="bake in bakes" :key="bake">
                <img src="../../assets/FoodImage_11.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ bake.cai }}</p>
                  <p>菜品序号：{{ bake.caiId}}</p>
                  <p>菜品价格：¥{{ bake.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(bake.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="iceCreams">冰淇淋</p>
            <ul>
              <li v-for="iceCream in iceCreams" :key="iceCream">
                <img src="../../assets/FoodImage_12.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ iceCream.cai }}</p>
                  <p>菜品序号：{{ iceCream.caiId}}</p>
                  <p>菜品价格：¥{{ iceCream.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(iceCream.caiId)">加入购物车</a>
                </div>
              </li>
            </ul>
          </li>

          <li>
            <p class="sub_title" id="childrenMeals">儿童餐</p>
            <ul>
              <li v-for="childrenMeal in childrenMeals" :key="childrenMeal">
                <img src="../../assets/FoodImage_13.png" class="foodDetailsImage">
                <div class="foodDetailsText">
                  <p>菜品名称：{{ childrenMeal.cai }}</p>
                  <p>菜品序号：{{ childrenMeal.caiId}}</p>
                  <p>菜品价格：¥{{ childrenMeal.caiJG }}</p>
                  <br>
                  <a href="#" v-on:click="doAddFood(childrenMeal.caiId)">加入购物车</a>
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
import {DoAddFood, DoLoadCategoryData, DoLoadFoodData} from "@/util/api";

export default {
  name: "MenuList",

  data() {
    return {
      categoryList: [],
      foodList: [],
      requestFoodId: "",
    }
  },

  computed: {
    hotSales: function () {
      return this.foodList.filter(food => food.leiId === 1);
    },
    singleMeals: function () {
      return this.foodList.filter(food => food.leiId === 2);
    },
    doubleMeals: function () {
      return this.foodList.filter(food => food.leiId === 3);
    },
    fullChickens: function () {
      return this.foodList.filter(food => food.leiId === 4);
    },
    friedChickens: function () {
      return this.foodList.filter(food => food.leiId === 5);
    },
    hamburgers: function () {
      return this.foodList.filter(food => food.leiId === 6);
    },
    rices: function () {
      return this.foodList.filter(food => food.leiId === 7);
    },
    drinks: function () {
      return this.foodList.filter(food => food.leiId === 8);
    },
    coffees: function () {
      return this.foodList.filter(food => food.leiId === 9);
    },
    desserts: function () {
      return this.foodList.filter(food => food.leiId === 10);
    },
    bakes: function () {
      return this.foodList.filter(food => food.leiId === 11);
    },
    iceCreams: function () {
      return this.foodList.filter(food => food.leiId === 12);
    },
    childrenMeals: function () {
      return this.foodList.filter(food => food.leiId === 13);
    },

  },
  mounted() {
    this.doLoadCategoryData();
    this.doLoadFoodData();
  },

  methods: {
    doLoadCategoryData: function () {
      DoLoadCategoryData().then(res => {this.categoryList = res;});
    },

    doLoadFoodData: function () {
      DoLoadFoodData().then((res) => {this.foodList = res;});
    },

    doAddFood: function (food) {
      let testParams = {
        caiId: food,
      }
      DoAddFood(testParams).then(res => {this.requestFoodId = res;});
      alert("已成功加入购物车！编号：" + food);
    }
  }
}
</script>

<style scoped>

</style>