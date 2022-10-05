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
          <router-link to="/Paragraph"><a>专栏</a></router-link>
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
          <router-link to="/Creator"><a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">创作中心</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Mine"><a>我的</a></router-link>
        </li>
      </ul>
    </div>

    <div id="creatorContent">
      <p class="creatorMainTitle">数据总览</p>
      <ul v-for="item in creatorData" v-bind:key="item">
        <li>
          <p class="creatorTitle">近7日阅读数</p>
          <p class="creatorNumber">12345</p>
          <p class="creatorPercentage">同比增加88%</p>
        </li>
        <li>
          <p class="creatorTitle">近7日赞同数</p>
          <p class="creatorNumber">23</p>
          <p class="creatorPercentage">同比增加233%</p>
        </li>
        <li>
          <p class="creatorTitle">近7日评论数</p>
          <p class="creatorNumber">6</p>
          <p class="creatorPercentage">同比增加67%</p>
        </li>
        <li>
          <p class="creatorTitle">近7日收益（元）</p>
          <p class="creatorNumber">88.88</p>
          <p class="creatorPercentage">同比增加268%</p>
        </li>
        <li>
          <p class="creatorTitle">总阅读数</p>
          <p class="creatorNumber">{{ item.tRead }}</p>
          <p class="creatorPercentage">已经超过12%的创作者啦</p>
        </li>
        <li>
          <p class="creatorTitle">总赞同数</p>
          <p class="creatorNumber">{{ item.tLike }}</p>
          <p class="creatorPercentage">已经超过15%的创作者啦</p>
        </li>
        <li>
          <p class="creatorTitle">总评论数</p>
          <p class="creatorNumber">{{ item.tComment }}</p>
          <p class="creatorPercentage">已经超过1%的创作者啦</p>
        </li>
        <li>
          <p class="creatorTitle">总收益（元）</p>
          <p class="creatorNumber">{{ item.tCash }}</p>
          <p class="creatorPercentage">已经超过24%的创作者啦</p>
        </li>
      </ul>
      <ul v-if="creatorData == false">
        <li>
          <p class="creatorTitle">近7日阅读数</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li>
          <p class="creatorTitle">近7日赞同数</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li>
          <p class="creatorTitle">近7日评论数</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li>
          <p class="creatorTitle">近7日收益（元）</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li>
          <p class="creatorTitle">总阅读数</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li>
          <p class="creatorTitle">总赞同数</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li>
          <p class="creatorTitle">总评论数</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li>
          <p class="creatorTitle">总收益（元）</p>
          <p class="creatorNumber">暂无</p>
          <p class="creatorPercentage">请先登录！</p>
        </li>
        <li style="background: none">
          <div id="enterCreatorCenter">
            <router-link to="/Mine"><a style="padding-left: 45px">进入登陆页面 ></a></router-link>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
/* eslint-disable*/
import {DoLoadLoggedUserInfoInCreatorCenter} from "@/utility/api";

export default {
  name: "Creator",
  data() {
    return {
      creatorData: []
    }
  },

  methods: {
    doLoadCreator: function () {
      DoLoadLoggedUserInfoInCreatorCenter().then(res => {
        this.creatorData = res;
      });
    },
  },

  mounted() {
    this.doLoadCreator();
  }
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Creator.css";
</style>