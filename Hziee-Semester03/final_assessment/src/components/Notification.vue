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
					<router-link to="/Notification"><a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">通知</a>
					</router-link>
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
					<router-link to="/Mine"><a>我的</a></router-link>
				</li>
			</ul>
		</div>
		
		<div id="pageLayoutList">
			<ul>
				<li>
					<div id="homePageContent" style="height: 100%">
						<p class="notificationMainTitle">通知中心</p>
						<table v-if="notificationFlag == true">
							<tr v-for="item in notificationData" v-bind:key="item">
								<td class="notificationIconClass" style="width: 45px">
									<img v-if="item.nClass == 1" alt="找不到图片" src="../assets/add.png">
									<img v-if="item.nClass == 2" alt="找不到图片" src="../assets/talk.png">
									<img v-if="item.nClass == 3" alt="找不到图片" src="../assets/up.png">
									<img v-if="item.nClass == 4" alt="找不到图片" src="../assets/view.png">
								</td>
								<td class="notificationContent" style="width: 600px">
									<p v-if="(item.nTitle.length) < 20" class="notificationLevel1">{{ item.nTitle }}</p>
									<p v-else class="notificationLevel1">{{ item.nTitle.substring(0, 20) }}...</p>
									<p v-if="(item.nContent.length) < 30" class="notificationLevel2">{{ item.nContent }}</p>
									<p v-else class="notificationLevel1">{{ item.nContent.substring(0, 30) }}...</p>
								</td>
								<td class="notificationOperation" style="width: 45px">
									<a class="notificationOperationButton" href="#" v-on:click="doDeleteNotification(item.uID, item.nID)">已读</a>
								</td>
							</tr>
						</table>
						<p v-if="notificationFlag == false" class="notificationNote">没有新的通知哦～</p>
					</div>
				</li>
				
				<li>
					<div v-for="item in creatorData" id="homePageSecondContent" v-bind:key="item">
						<br>
						<a id="creatorCenterTitle">创作中心</a>
						<br>
						<img alt="找不到图片" v-bind:src="require('@/assets/avatar/' + item.uAvatar)">
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
								<p class="bigDataContent">{{ item.tLike }}</p>
							</li>
							<li>
								<p class="bigDataTitle">金币数</p>
								<p class="bigDataContent">{{ item.tCoin }}</p>
							</li>
						</ul>
						<br>
						<div id="enterCreatorCenter">
							<router-link to="/Creator"><a href="#">进入创作中心 ></a></router-link>
						</div>
					</div>
					<div v-if="creatorData == false" id="homePageSecondContent">
						<br>
						<a id="creatorCenterTitle">创作中心</a>
						<br>
						<img alt="找不到图片" src="../assets/avatar/avataaars-10.png">
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
							<router-link to="/Mine"><a href="#">进入登陆页面 ></a></router-link>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
/* eslint-disable*/
import {DoDeleteNotification, DoLoadLoggedUserInfoInCreatorCenter, DoLoadNotification} from "@/utility/api";

export default {
	name: "Notification",
	data() {
		return {
			creatorData: [],
			notificationData: [],
			returnedDeleteNotificationCode: 0,
			notificationFlag: true,
			enteredSearchContent: ""
		}
	},
	
	methods: {
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
				let testParams = {
					uID: this.creatorData[0].uID
				}
				DoLoadNotification(testParams).then(res => {
					this.notificationData = res;
					this.notificationFlag = this.notificationData.length > 0;
				})
			});
		},
		
		doDeleteNotification: function (uID, nID) {
			let testParams = {
				uID: uID,
				nID: nID
			}
			DoDeleteNotification(testParams);
			location.reload();
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
		this.doLoadLoggedUserInfoInCreatorCenter();
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Notification.css";
</style>