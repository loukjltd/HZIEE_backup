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
					<input id="navBarSearchBox" v-model="enteredSearchContent" placeholder="请搜索想要搜索的内容"
					       type="search">
					<input id="navBarSearchButton" type="button" value="搜索" v-on:click="doSearchDatabase()">
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Creator"><a>创作中心</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Mine"><a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">我的</a>
					</router-link>
				</li>
			</ul>
		</div>
		
		<div id="pageLayoutList">
			<ul>
				<li>
					<div id="mineContent">
						<p class="mineMainTitle">登陆</p>
						<p style="text-align: center; color: #DAE9FC; margin-top: 15px">————————————————————————————————</p>
						<div class="mineMainContent">
							<!--							<p v-if="filterUser == true" class="mineLogNote">如果需要重新登录，请先退出登录</p>-->
							<form>
								<input v-model="enteredPhone" class="enterInfo" placeholder="请输入电话号码" type="text">
								<br>
								<input v-model="enteredPassword" class="enterInfo" placeholder="请输入密码" type="password">
								<br>
								<br>
								<input class="enterButton" name="chooseLogIn" type="button" value="登陆"
								       v-on:click="doLogInUser(0)">
							</form>
						</div>
						<div v-for="item in filterUser" v-bind:key="item">
							<p style="text-align: center; color: #DAE9FC; margin-top: 15px">————————————————————————————————</p>
							<p class="mineMainTitle">当前已登陆用户</p>
							<p class="mineMainLoggedUser">{{ item.uNickName }}</p>
							<p v-if="filterUser == false" class="mineMainLoggedUser">未登陆！</p>
							<div class="mineMainContent">
								<form v-for="item in filterUser" v-bind:key="item">
									<input class="enterButton" name="chooseExitLogIn"
									       type="button" value="退出登录" v-on:click="doLogOutUser(item.uNickName)">
									<input class="enterButton" name="chooseEveryDaySignIn" style="text-align: center" type="button"
									       value="签到" v-on:click="doEverydaySign(item.uID)">
								</form>
							</div>
						</div>
					</div>
				</li>
				
				<li>
					<div id="mineSecondContent">
						<p class="mineMainTitle">注册</p>
						<p style="text-align: center; color: #DAE9FC; margin-top: 15px">————————————————————————————————</p>
						<div class="mineMainContent">
							<form>
								<input v-model="enteredRegPhone" class="enterInfo" placeholder="请输入电话号码" type="text">
								<br>
								<input v-model="enteredRegPassword" class="enterInfo" placeholder="请输入密码" type="password">
								<br>
								<input v-model="enteredRegNickName" class="enterInfo" placeholder="请输入昵称" type="text">
								<br>
								<input v-model="enteredRegMotto" class="enterInfo" placeholder="请输入签名" type="text">
								<br>
								<div class="acceptOrNotTitle">
									<input v-model="enteredRegAgreement" class="acceptOrNotContent" name="acceptAgreement"
									       type="checkbox">
									<a class="extraInfo">&nbsp;我接受《有偿在线问答系统最终用户许可协议》</a>
								</div>
								<br>
								<input class="enterButton" name="chooseLogIn" type="button" value="注册"
								       v-on:click="doRegisterAccount()">
							</form>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>

</template>

<script>
import {
	DoCheckIfThereIsLoggedUser,
	DoEveryDaySignIn,
	DoInsertRelatedTaskWithNewUser,
	DoLogInUser,
	DoLogOutUser,
	DoRegisterAccount
} from "@/utility/api";

export default {
	/* eslint-disable*/
	name: "Mine",
	data() {
		return {
			enteredPhone: "",
			enteredPassword: "",
			enteredRegPhone: "",
			enteredRegPassword: "",
			enteredRegNickName: "",
			enteredRegMotto: "",
			enteredRegAgreement: false,
			returnedUser: [],
			returnedLogResultCode: [],
			returnedRegisterResultCode: [],
			returnedOutUser: [],
			returnedEveryDaySignIn: [],
			enteredSearchContent: ""
		}
	},
	
	methods: {
		doCheckIfThereIsLoggedUser: function () {
			DoCheckIfThereIsLoggedUser().then(res => {
				this.returnedUser = res;
			});
		},
		
		doLogInUser: function (adminFlag) {
			let currentTime = new Date();
			let testParams = {
				uPhone: this.enteredPhone,
				uPassword: this.enteredPassword,
				adminFlag: adminFlag,
				uLastLoggedTime: currentTime.toLocaleString()
			};
			DoLogInUser(testParams).then(res => {
				this.returnedLogResultCode = res;
				switch (this.returnedLogResultCode) {
					case 100:
						alert("登陆成功！");
						break;
					case 133:
						alert("登陆用户组错误！");
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
		},
		
		doRegisterAccount: function () {
			let generateRandomID = Math.round(Math.random() * 89999 + 10000);
			let generateRandomAvatar = Math.round(Math.random() * 49 + 1);
			let testParams = {
				uID: generateRandomID,
				uAvatar: "avataaars-" + generateRandomAvatar.toString() + ".png",
				uPhone: this.enteredRegPhone,
				uPassword: this.enteredRegPassword,
				uNickName: this.enteredRegNickName,
				uMotto: this.enteredRegMotto
			};
			let onlyEuID = {
				uID: generateRandomID
			}
			DoRegisterAccount(testParams).then(res => {
				this.returnedRegisterResultCode = res;
				if (this.enteredRegAgreement === false) {
					alert("请接受《有偿在线问答系统最终用户许可协议》！");
				} else {
					switch (this.returnedRegisterResultCode) {
						case 200:
							DoInsertRelatedTaskWithNewUser(onlyEuID);
							alert("注册成功！");
							location.reload();
							break;
						case 201:
							alert("输入手机号的格式不正确！")
							break;
						case 202:
							alert("输入密码的位数过短！")
							break;
						case 244:
							alert("注册失败！");
							break;
						case 222:
							alert("请填写完整信息！");
							break;
						case 233:
							alert("该账号或昵称已被注册！");
							break;
					}
					console.log("登陆返回结果代码为：" + this.returnedLogResultCode);
				}
			})
		},
		
		doEverydaySign: function (uID) {
			let testParams = {
				uID: uID
			};
			DoEveryDaySignIn(testParams).then(res => {
				this.returnedEveryDaySignIn = res;
				alert("签到成功，点击确认跳转领取金币！")
				this.$router.push({path: "/Task"});
			})
		}
	},
	
	computed: {
		filterUser: function () {
			return this.returnedUser.filter(res => {
				return res.uIfLogged === 1 && res.uGroup === 1;
			})
		},
		
		doSearchDatabase: function () {
			this.$router.push({
				path: '/SearchResult',
				query: {
					srContent: this.enteredSearchContent
				}
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