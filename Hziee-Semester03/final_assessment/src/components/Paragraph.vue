<template>
  <div>
    <div id="navBar">
      <ul>
        <li class="navBarCommonItem">
          <router-link to="/"><a>首页</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Question"><a>提问</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Paragraph"><a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">专栏</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Task"><a>任务</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Notification"><a>通知</a></router-link>
        </li>
        <li>
          <input type="search" placeholder="请搜索想要搜索的内容" id="navBarSearchBox">
          <input type="button" value="搜索" id="navBarSearchButton">
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Creator"><a>创作中心</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Mine"><a>我的</a></router-link>
        </li>
      </ul>
    </div>

    <div id="pageLayoutList">
      <ul>
        <li>
          <div id="paragraphContent">
            <ul>
              <li v-for="item in paragraphData" v-bind:key="item">
                <a class="contentCategory">专</a>
                <a class="contentTitle"><b>&nbsp;{{ item.pTitle }}</b></a>
                <br>
                <img v-bind:src="require('@/assets/avatar/' + item.uAvatar)" alt="找不到图片">
                <a class="contentNickName" href="#">{{ item.uNickName }}&nbsp;</a>
                <a class="contentMotto">&nbsp;{{ item.uMotto }}</a>
                <br>
                <br>
                <a class="contentInfo">{{ item.pContent }}</a>
                <br>
                <a class="contentLikeNumber">△&nbsp;赞同&nbsp;{{item.pLike}}</a>
                <a class="contentLikeNumber">▽</a>
                <hr>
              </li>
            </ul>

            <div id="bottomLine">
              <br><br><br>
              <p>——————————我是有底线的～！——————————</p>
            </div>
          </div>
        </li>

        <li>
          <div id="homePageSecondContent" v-for="item in creatorData" v-bind:key="item">
            <br>
            <a id="creatorCenterTitle">创作中心</a>
            <br>
            <img v-bind:src="require('@/assets/avatar/' + item.uAvatar)" alt="找不到图片">
            <br>
            <a id="creatorCenterSecondContent">{{ item.uNickName }}</a>
            <br>
            <br>
            <ul id="activityButton">
              <li>
                <img src="../assets/system/Answer.png">
                <p>回答问题</p>
              </li>
              <li>
                <img src="../assets/system/Question.png">
                <p>提出问题</p>
              </li>
              <li>
                <img src="../assets/system/Paragraph.png">
                <p>写文章</p>
              </li>
              <li>
                <img src="../assets/system/Task.png">
                <p>做任务</p>
              </li>
            </ul>
            <br>
            <ul id="bigDataNumber">
              <li>
                <p class="bigDataTitle">阅读数</p>
                <p class="bigDataContent">{{ item.tRead }}</p>
              </li>
              <li>
                <p class="bigDataTitle">点赞数</p>
                <p class="bigDataContent">{{ item.tLike}}</p>
              </li>
              <li>
                <p class="bigDataTitle">金币数</p>
                <p class="bigDataContent">{{ item.tCoin }}</p>
              </li>
            </ul>
            <br>
            <div id="enterCreatorCenter">
              <router-link to="/Creator"><a>进入创作中心 ></a></router-link>
            </div>
          </div>
          <div id="homePageSecondContent" v-if="creatorData == false">
            <br>
            <a id="creatorCenterTitle">创作中心</a>
            <br>
            <img src = "../assets/avatar/avataaars-10.png" alt="找不到图片">
            <br>
            <a id="creatorCenterSecondContent">请先登陆！</a>
            <br>
            <br>
            <ul id="activityButton">
              <li>
                <img src="../assets/system/Answer.png">
                <p>回答问题</p>
              </li>
              <li>
                <img src="../assets/system/Question.png">
                <p>提出问题</p>
              </li>
              <li>
                <img src="../assets/system/Paragraph.png">
                <p>写文章</p>
              </li>
              <li>
                <img src="../assets/system/Task.png">
                <p>做任务</p>
              </li>
            </ul>
            <br>
            <ul id="bigDataNumber">
              <li>
                <p class="bigDataTitle">阅读数</p>
                <p class="bigDataContent">暂无</p>
              </li>
              <li>
                <p class="bigDataTitle">点赞数</p>
                <p class="bigDataContent">暂无</p>
              </li>
              <li>
                <p class="bigDataTitle">金币数</p>
                <p class="bigDataContent">暂无</p>
              </li>
            </ul>
            <br>
            <div id="enterCreatorCenter">
              <router-link to="/Mine"><a>进入登陆页面 ></a></router-link>
            </div>
          </div>
        </li>
      </ul>
    </div>


  </div>
</template>

<script>
import {DoLoadLoggedUserInfoInCreatorCenter, DoLoadParagraphData} from "@/utility/api";

/* eslint-disable*/
export default {
  name: "Paragraph",
  data() {
    return {
      paragraphData: [],
      creatorData: []
    }
  },

  methods: {
    doLoadParagraph: function () {
      DoLoadParagraphData().then(res => {
        this.paragraphData = res;
      });
    },

    doLoadLoggedUserInfoInCreatorCenter: function () {
      DoLoadLoggedUserInfoInCreatorCenter().then(res => {
        this.creatorData = res;
      });
    }
  },

  mounted() {
    this.doLoadParagraph();
    this.doLoadLoggedUserInfoInCreatorCenter();
  }
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Paragraph.css";
</style>