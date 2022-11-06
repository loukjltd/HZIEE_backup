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
					<router-link to="/Task"><a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">任务</a>
					</router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Notification"><a>通知</a></router-link>
				</li>
				<li>
					<input id="navBarSearchBox" placeholder="请搜索想要搜索的内容" type="search">
					<input id="navBarSearchButton" type="button" value="搜索">
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Creator"><a>创作中心</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Mine"><a>我的</a></router-link>
				</li>
			</ul>
		</div>
		
		<div id="taskContent">
			<p class="taskMainTitle">任务中心</p>
			<p v-if="filterUser == false" class="mineMainLoggedUser">未登陆！</p>
			<ul v-else-if="filterUser">
				<li v-for="item in returnedTaskInfo" v-bind:key="item">
					<a>任务：</a>
					<a>{{ item.tContent }}</a>
					<br>
					<a>完成进度：</a>
					<a style="color: #056DE8; font-weight: bold">{{ item.tProgress }} / {{ item.tFinish }}</a>
					<br>
					<div style="padding-top: 10px;">
						<img alt="" class="coinImage" src="../assets/coin.png">
						<a class="coinValue" style="font-weight: bold; vertical-align: 2px">&nbsp;{{ item.tValue }}</a>
					</div>
					<input v-if="item.tProgress != item.tFinish && item.tStatus != 1"
					       style="color: white; background-color: #8893A8" type="button"
					       value="任务未完成"
					       v-on:click="doCheckTaskStatus(false, item.uID, item.tContent, item.tStatus)">
					<input v-else-if="item.tProgress == item.tFinish && item.tStatus != 1" type="button" value="领取奖励"
					       v-on:click="doCheckTaskStatus(true, item.uID, item.tContent, item.tStatus)">
					<input v-else-if="item.tProgress == item.tFinish && item.tStatus == 1"
					       style="color: white; background-color: #8893A8" type="button" value="奖励已领取"
					       v-on:click="doCheckTaskStatus(true, item.uID, item.tContent, item.tStatus)">
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
/* eslint-disable*/
import {
	DoCheckIfThereIsLoggedUser,
	DoLoadLoggedUserInfoInCreatorCenter,
	DoLoadTaskInfo,
	DoParseTaskContent,
	DoTaskUpdateUserCoin
} from "@/utility/api";

export default {
	name: "Task",
	data() {
		return {
			returnedUser: [],
			returnedTaskInfo: [],
			creatorData: [],
			taskUpdateStatusResultCode: [],
			taskUpdateUserCoinResultCode: []
		}
	},
	
	methods: {
		doCheckIfThereIsLoggedUser: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
			DoCheckIfThereIsLoggedUser().then(res => {
				this.returnedUser = res;
				let testParams = {
					uID: this.creatorData[0].uID
				};
				if (this.returnedUser) {
					DoLoadTaskInfo(testParams).then(res => {
						this.returnedTaskInfo = res;
					})
				}
			});
		},
		
		doCheckTaskStatus: function (flag, uID, tContent, tStatus) {
			if (!flag) {
				alert("任务未完成，请先完成任务！");
				location.reload();
			} else if (flag == true && tStatus != 1) {
				let testParams = {
					uID: uID,
					tContent: tContent
				}
				DoParseTaskContent(testParams).then(res => {
					this.taskUpdateStatusResultCode = res;
					switch (this.taskUpdateStatusResultCode) {
						case 100:
							DoTaskUpdateUserCoin(testParams).then(res => {
								this.taskUpdateUserCoinResultCode = res;
								switch (this.taskUpdateStatusResultCode) {
									case 100:
										alert("任务完成，奖励已领取！");
										location.reload();
								}
							});
					}
				})
			} else if (flag == true && tStatus == 1) {
				alert("已经领取过奖励！")
				location.reload();
			}
		}
	},
	
	computed: {
		filterUser: function () {
			return this.returnedUser.filter(res => {
				return res.uIfLogged === 1 && res.uGroup === 1;
			})
		},
	},
	
	mounted() {
		this.doCheckIfThereIsLoggedUser();
		this.filterUser();
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Task.css";
</style>