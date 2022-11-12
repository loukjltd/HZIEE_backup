<template>
	<div>
		<div id="navBar">
			<ul>
				<li class="navBarCommonItem">
					<a style="color: black; font-weight: bold">有偿问答后台管理系统</a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<a></a>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/"><a>退出后台管理系统</a></router-link>
				</li>
			</ul>
		</div>
		
		<div id="pageLayoutList">
			<ul>
				<li>
					<div id="adminManagerContent">
						<p v-if="filterUser == false" style="padding-left: 35px; padding-top: 35px">请先登陆！</p>
						<div v-else>
							<p class="adminMainTitle">用户管理</p>
							<table class="adminTable">
								<tr class="adminTableTitleCol">
									<td>用户ID</td>
									<td>昵称</td>
									<td>是否在线</td>
									<td>用户组</td>
									<td>上次登陆日期</td>
									<td>操作</td>
								</tr>
								<tr v-for="item in returnedAllUserInfo" v-bind:key="item">
									<td>{{ item.uID }}</td>
									<td>{{ item.uNickName }}</td>
									<td v-if="item.uIfLogged == 1">是</td>
									<td v-if="item.uIfLogged == 0">否</td>
									<td v-if="item.uGroup == 1">注册用户</td>
									<td v-if="item.uGroup == 0">管理员</td>
									<td>
										{{ item.uLastLoggedTime.substring(0, 4) + "年" +
									item.uLastLoggedTime.substring(5, 7) + "月" +
									item.uLastLoggedTime.substring(8, 10) + "日 " +
									item.uLastLoggedTime.substring(11, 19)
										}}
									</td>
									<td>
										<a class="adminOperationButton" href="#"
										   style="margin-left: -15px"
										   v-on:click="doChooseSendNotification(notificationFlag, item.uID)">发送通知</a>
										<a class="adminOperationButton" href="#" v-on:click="doAdminDeleteUser(item.uID)">删除</a>
									</td>
								</tr>
							</table>
							<form v-if="this.notificationFlag">
								<textarea id="adminNotification" v-model="enteredNotificationContent" style="margin-top: 20px"
								          v-bind:placeholder="chooseUser"></textarea>
								<input class="enterButton"
								       style="margin-left: 50px; margin-top: -20px"
								       type="button" value="发送通知"
								       v-on:click="doAdminSendNotification()">
							</form>
							
							<p class="adminMainTitle">专栏管理</p>
							<table class="adminTable">
								<tr class="adminTableTitleCol">
									<td>作者ID</td>
									<td>作者</td>
									<td>专栏ID</td>
									<td>专栏名称</td>
									<td>操作</td>
								</tr>
								<tr v-for="item in returnedAllParagraphInfo" v-bind:key="item">
									<td>{{ item.uID }}</td>
									<td>{{ item.uNickName }}</td>
									<td>{{ item.pID }}</td>
									<td v-if="(item.pTitle).length < 20">{{ item.pTitle }}</td>
									<td v-else>{{ item.pTitle.substring(0, 20) }}...</td>
									<td>
										<a class="adminOperationButton" href="#"
										   v-on:click="doAdminViewParagraph(item.uID, item.pID)">查看</a>
										<a class="adminOperationButton" href="#"
										   v-on:click="doAdminDeleteParagraph(item.uID, item.pID)">删除</a>
									</td>
								</tr>
							</table>
							<p class="adminMainTitle">问题管理</p>
							<table class="adminTable">
								<tr class="adminTableTitleCol">
									<td>作者ID</td>
									<td>作者</td>
									<td>问题ID</td>
									<td>问题名称</td>
									<td>操作</td>
								</tr>
								<tr v-for="item in returnedAllQuestionInfo" v-bind:key="item">
									<td>{{ item.uID }}</td>
									<td>{{ item.uNickName }}</td>
									<td>{{ item.qID }}</td>
									<td v-if="(item.qTitle).length < 20">{{ item.qTitle }}</td>
									<td v-else>{{ item.qTitle.substring(0, 20) }}...</td>
									<td>
										<a class="adminOperationButton" href="#"
										   v-on:click="doAdminViewQuestion(item.uID, item.qID)">查看</a>
										<a class="adminOperationButton" href="#"
										   v-on:click="doAdminDeleteQuestion(item.uID, item.qID)">删除</a>
									</td>
								</tr>
							</table>
							<p class="adminMainTitle">回答管理</p>
							<table class="adminTable">
								<tr class="adminTableTitleCol">
									<td>作者ID</td>
									<td>作者</td>
									<td>问题ID</td>
									<td>问题</td>
									<td>回答ID</td>
									<td>回答</td>
									<td>操作</td>
								</tr>
								<tr v-for="item in returnedAllAnswerInfo" v-bind:key="item">
									<td>{{ item.uID }}</td>
									<td>{{ item.uNickName }}</td>
									<td>{{ item.qID }}</td>
									<td v-if="(item.qTitle).length < 12">{{ item.qTitle }}</td>
									<td v-else>{{ item.qTitle.substring(0, 12) }}...</td>
									<td>{{ item.aID }}</td>
									<td v-if="(item.aContent).length < 12">{{ item.aContent }}</td>
									<td v-else>{{ item.aContent.substring(0, 12) }}...</td>
									<td>
										<a class="adminOperationButton" href="#"
										   v-on:click="doAdminViewAnswer(item.uID, item.qID, item.aID, item.qTitle)">查看</a>
										<a class="adminOperationButton" href="#"
										   v-on:click="doAdminDeleteAnswer(item.uID, item.qID, item.aID)">删除</a>
									</td>
								</tr>
							</table>
						</div>
						
						<div id="bottomLine">
							<br><br><br>
							<p>-&nbsp;&nbsp;到底啦&nbsp;&nbsp;-</p>
						</div>
					</div>
				</li>
				
				<li>
					<div id="adminManagerSecondContent">
						<br>
						<p class="adminManagerTitle">后台登陆</p>
						<br>
						<br>
						<form v-if="filterUser == false">
							<input v-model="enteredPhone" class="adminLogInEnterInfo" placeholder="请输入账号" type="text">
							<br>
							<input v-model="enteredPassword" class="adminLogInEnterInfo" placeholder="请输入密码" type="password">
							<br>
							<input class="enterButton" style="margin-bottom: 30px" type="button" value="登陆"
							       v-on:click="doLogInUser(1)">
						</form>
						<p class="adminManagerTitle">当前已登陆管理员</p>
						<br>
						<p v-for="item in filterUser" v-bind:key="item" class="adminManagerMainLoggedUser">{{ item.uNickName }}</p>
						<p v-if="filterUser == false" class="adminManagerMainLoggedUser">未登陆！</p>
						<div class="adminManagerMainContent">
							<form v-for="item in filterUser" v-bind:key="item">
								<input class="enterButton" name="chooseExitLogIn" style="margin-left: -55px"
								       type="button" value="退出登录" v-on:click="doLogOutUser(item.uNickName)">
							</form>
						</div>
						<br>
						<br>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
import {
	DoAdminDeleteAnswer,
	DoAdminDeleteParagraph,
	DoAdminDeleteQuestion,
	DoAdminDeleteUser,
	DoAdminSendNotification,
	DoCheckIfThereIsLoggedUser,
	DoLoadAllAnswerInfo,
	DoLoadAllParagraphInfo,
	DoLoadAllQuestionInfo,
	DoLoadAllUserInfo,
	DoLogInUser,
	DoLogOutUser
} from "@/utility/api";

export default {
	/* eslint-disable*/
	name: "AdminManager",
	data() {
		return {
			returnedUser: [],
			enteredPhone: "",
			enteredPassword: "",
			returnedAllUserInfo: [],
			returnedAllParagraphInfo: [],
			returnedAllQuestionInfo: [],
			returnedAllAnswerInfo: [],
			returnedDeleteUserCode: 0,
			returnedDeleteParagraphCode: 0,
			returnedDeleteQuestionCode: 0,
			returnedSendNotificationCode: 0,
			notificationFlag: false,
			saveChooseNotificationUserID: 0,
			enteredNotificationContent: "",
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
			let testParams = {
				uPhone: this.enteredPhone,
				uPassword: this.enteredPassword,
				adminFlag: adminFlag,
				uLastLoggedTime: new Date().toLocaleString()
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
				location.reload();
			});
		},
		
		doLogOutUser: function (uNickName) {
			let testParams = {
				uNickName: uNickName
			};
			DoLogOutUser(testParams);
			alert("退出成功！");
			location.reload();
		},
		
		doLoadAllUserInfo: function () {
			DoLoadAllUserInfo().then(res => {
				this.returnedAllUserInfo = res;
			});
		},
		
		doLoadAllParagraphInfo: function () {
			DoLoadAllParagraphInfo().then(res => {
				this.returnedAllParagraphInfo = res;
			});
		},
		
		doLoadAllQuestionInfo: function () {
			DoLoadAllQuestionInfo().then(res => {
				this.returnedAllQuestionInfo = res;
			});
		},
		
		doLoadAllAnswerInfo: function () {
			DoLoadAllAnswerInfo().then(res => {
				this.returnedAllAnswerInfo = res;
			});
		},
		
		doAdminViewParagraph: function (uID, pID) {
			this.$router.push({
				path: "/ParagraphSubPage",
				query: {
					uID: uID,
					pID: pID
				}
			});
		},
		
		doAdminViewQuestion: function (uID, qID) {
			this.$router.push({
				path: "/QuestionSubPage",
				query: {
					uID: uID,
					qID: qID
				}
			});
		},
		
		doAdminViewAnswer: function (uID, qID, aID, qTitle) {
			this.$router.push({
				path: "/AnswerSubPage",
				query: {
					uID: uID,
					qID: qID,
					aID: aID,
					qTitle: qTitle
				}
			});
		},
		
		doAdminDeleteUser: function (uID) {
			let testParams = {
				uID: uID
			};
			if (testParams.uID == 10000) {
				alert("无法删除管理员账号！");
			} else {
				DoAdminDeleteUser(testParams).then(res => {
					this.returnedDeleteUserCode = res;
					switch (this.returnedDeleteUserCode) {
						case 100:
							alert("删除成功！");
							break;
					}
				});
			}
			location.reload();
		},
		
		doAdminDeleteParagraph: function (uID, pID) {
			let testParams = {
				uID: uID,
				pID: pID
			};
			DoAdminDeleteParagraph(testParams).then(res => {
				this.returnedDeleteParagraphCode = res;
				switch (this.returnedDeleteParagraphCode) {
					case 100:
						alert("删除成功！");
						break;
				}
			});
			location.reload();
		},
		
		doAdminDeleteQuestion: function (uID, qID) {
			let testParams = {
				uID: uID,
				qID: qID
			};
			DoAdminDeleteQuestion(testParams).then(res => {
				this.returnedDeleteQuestionCode = res;
				switch (this.returnedDeleteQuestionCode) {
					case 100:
						alert("删除成功！");
						break;
				}
			});
			location.reload();
		},
		
		doAdminDeleteAnswer: function (uID, qID, aID) {
			let testParams = {
				uID: uID,
				qID: qID,
				aID: aID
			};
			DoAdminDeleteAnswer(testParams).then(res => {
				this.returnedDeleteAnswerCode = res;
				switch (this.returnedDeleteAnswerCode) {
					case 100:
						alert("删除成功！");
						break;
				}
			});
			location.reload();
		},
		
		doChooseSendNotification: function (notificationFlag, uID) {
			this.saveChooseNotificationUserID = uID;
			this.notificationFlag = !notificationFlag;
		},
		
		doAdminSendNotification: function () {
			let testParams = {
				uID: this.saveChooseNotificationUserID,
				nTitle: "来自管理员的重要通知",
				nContent: this.enteredNotificationContent,
				nClass: 4
			}
			DoAdminSendNotification(testParams).then(res => {
				this.returnedSendNotificationCode = res;
				switch (this.returnedSendNotificationCode) {
					case 100:
						alert("发送成功！");
						break;
				}
			});
		}
	},
	
	computed: {
		filterUser: function () {
			return this.returnedUser.filter(res => {
				return res.uIfLogged === 1 && res.uGroup === 0;
			})
		},
		
		chooseUser() {
			const staticGrammar = "您已选择用户ID：";
			return staticGrammar + this.saveChooseNotificationUserID;
		}
	},
	
	mounted() {
		this.doCheckIfThereIsLoggedUser();
		this.doLoadAllUserInfo();
		this.doLoadAllParagraphInfo();
		this.doLoadAllQuestionInfo();
		this.doLoadAllAnswerInfo();
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/AdminManager.css";
</style>