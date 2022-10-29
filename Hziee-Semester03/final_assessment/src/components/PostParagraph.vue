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
		
		<div id="pageLayoutList">
			<ul>
				<li>
					<div id="postParagraphContent">
						<p class="postParagraphMainTitle">撰写专栏</p>
						<div class="postMainContent">
							<form v-for="item in creatorData" v-bind:key="item" name="commentPart">
								<input v-model="enteredQuestionTitle" class="enterPostTitle" placeholder="请输入标题"
								       type="text">
								<br>
								<a class="contentLikeNumber" href="#" v-on:click="doAddEnterTextToTextArea()">插入换行符号</a>
								<a class="contentLikeNumber" href="#" v-on:click="doAddSingleLineToTextArea()">插入分割线</a>
								<textarea v-model="enteredQuestionContent" class="enterPostContent"
								          name="commentArea" placeholder="请输入正文"></textarea>
								<br>
								<input class="enterButton" type="button" value="发布专栏"
								       v-on:click="doInsertParagraphToDatabase(item.uID)">
							</form>
						</div>
						<br>
						<div id="bottomLine">
							<br><br><br>
							<p>-&nbsp;&nbsp;到底啦&nbsp;&nbsp;-</p>
						</div>
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
							<router-link to="/Creator"><a>进入创作中心 ></a></router-link>
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
							<router-link to="/Mine"><a>进入登陆页面 ></a></router-link>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
/* eslint-disable*/
import {DoInsertParagraphToDatabase, DoLoadLoggedUserInfoInCreatorCenter} from "@/utility/api";

export default {
	name: "PostParagraph",
	data() {
		return {
			creatorData: [],
			enteredQuestionTitle: "",
			enteredQuestionContent: "",
			returnedPostQuestionResultCode: []
		}
	},
	
	methods: {
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
		
		doInsertParagraphToDatabase: function (uID) {
			let testParams = {
				qTitle: this.enteredQuestionTitle,
				qContent: this.enteredQuestionContent,
				uID: uID
			}
			DoInsertParagraphToDatabase(testParams).then(res => {
				this.returnedPostQuestionResultCode = res;
				switch (this.returnedPostQuestionResultCode) {
					case 100:
						alert("提交专栏成功！");
						this.$router.push("/Paragraph");
				}
			})
		},
		
		doAddEnterTextToTextArea: function () {
			const text = "<br>";
			document.forms[0].commentArea.value += text;
		},
		
		doAddSingleLineToTextArea: function () {
			const text = "----------------------------------------";
			document.forms[0].commentArea.value += text;
		},
	},
	
	mounted() {
		this.doLoadLoggedUserInfoInCreatorCenter();
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Paragraph.css";
</style>