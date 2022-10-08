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
          <router-link to="/Creator"><a>创作中心</a></router-link>
        </li>
        <li class="navBarCommonItem">
          <router-link to="/Mine"><a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">我的</a></router-link>
        </li>
      </ul>
    </div>

    <div id="pageLayoutList">
      <ul>
        <li>
          <div id="mineContent">
            <p class="mineMainTitle">登陆</p>
            <div class="mineMainContent">
              <form>
                <input type="text" placeholder="请输入电话号码" class="enterInfo" v-model="enteredPhone">
                <br>
                <input type="password" placeholder="请输入密码" class="enterInfo" v-model="enteredPassword">
                <br>
                <div class="acceptOrNotTitle">
                  <input type="checkbox" name="savePassword" class="acceptOrNotContent">
                  <a>&nbsp;保存密码</a>
                </div>
                <br>
                <input type="button" name="chooseLogIn" value="登陆" class="enterButton" v-on:click="doLogInUser()">
              </form>
            </div>
            <p style="text-align: center; color: #DAE9FC; margin-top: 25px">——————————————————————————————</p>
            <p class="mineMainTitle">当前已登陆用户</p>
            <p class="mineMainLoggedUser" v-for="item in filterUser" v-bind:key="item">{{ item.uNickName }}</p>
            <p class="mineMainLoggedUser" v-if="filterUser == false">未登陆！</p>
            <div class="mineMainContent">
              <form>
                <input type="button" name="chooseExitLogIn" value="退出登录" class="enterButton"
                       v-for="item in filterUser" v-bind:key="item" v-on:click="doLogOutUser(item.uNickName)">
              </form>
            </div>
          </div>
        </li>

        <li>
          <div id="mineSecondContent">
            <p class="mineMainTitle">注册</p>
            <div class="mineMainContent">
              <form>
                <input type="text" name="enterPhone" placeholder="请输入电话号码" class="enterInfo">
                <br>
                <input type="password" name="enterPassword" placeholder="请输入密码" class="enterInfo">
                <br>
                <input type="text" name="enterNickName" placeholder="请输入昵称" class="enterInfo">
                <br>
                <input type="text" name="enterMotto" placeholder="请输入签名" class="enterInfo">
                <br>
                <div class="acceptOrNotTitle">
                  <input type="checkbox" name="acceptAgreement" class="acceptOrNotContent">
                  <a class="extraInfo">&nbsp;我接受《有偿在线问答系统最终用户许可协议》</a>
                </div>
                <br>
                <input type="submit" name="chooseRegister" value="注册" class="enterButton">
              </form>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>

</template>

<script>
/* eslint-disable*/
import {DoCheckIfThereIsLoggedUser, DoLogInUser, DoLogOutUser} from "@/utility/api";

export default {
  name: "Mine",
  data() {
    return {
      enteredPhone: "",
      enteredPassword: "",
      returnedUser: [],
      returnedLogResultCode: [],
      returnedOutUser: []
    }
  },

  methods: {
    doCheckIfThereIsLoggedUser: function () {
      DoCheckIfThereIsLoggedUser().then(res => {
        this.returnedUser = res;
      });
    },

    doLogInUser: function () {
      let testParams = {
        uPhone: this.enteredPhone,
        uPassword: this.enteredPassword
      };
      DoLogInUser(testParams).then(res => {
        this.returnedLogResultCode = res;
        switch (this.returnedLogResultCode) {
          case 100:
            alert("登陆成功！");
            break;
          case 144:
            alert("账号或密码错误！");
            break;
          case 122:
            alert("请填写账号或密码！");
            break;
        }
        // console.log("登陆返回结果代码为：" + this.returnedLogResultCode);
        location.reload();
      });
    },

    doLogOutUser: function (uNickName) {
      let testParams = {
        uNickName: uNickName
      };
      DoLogOutUser(testParams).then(res => {
        this.returnedOutUser = res;
        alert("退出成功！");
      });
      location.reload();
    }
  },

  computed: {
    filterUser: function () {
      return this.returnedUser.filter(res => {
        return res.uIfLogged === 1;
      })
    }
  },

  mounted() {
    this.doCheckIfThereIsLoggedUser();
  }
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Mine.css";
</style>