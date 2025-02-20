<template>
<view class="content">
	<view :style='{"minHeight":"100vh","padding":"260rpx 0 300rpx","borderColor":"#21d5ae","background":"url(http://codegen.caihongy.cn/20221223/47f4db5577fb492886b192809902163b.gif) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/ec4debd06eba457ca416dd1e20bdea56.gif) no-repeat left bottom / 100% auto,#192231","borderWidth":"0px 0 0","width":"100%","position":"relative","borderStyle":"dashed","height":"auto"}'>
		<form :style='{"width":"100%","padding":"60rpx 40rpx","background":"none","display":"block","height":"auto"}'>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 40rpx","borderColor":"#49a2af","alignItems":"center","display":"flex","minHeight":"100rpx","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#4a8189","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' v-model="forum.title" placeholder="标题"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 40rpx","borderColor":"#49a2af","alignItems":"center","display":"flex","minHeight":"100rpx","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
				<picker :style='{"width":"100%","background":"","height":"auto"}' @change="setIsDoneTap" :value="index" :range="options">
					<view class="uni-picker-type" :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#4a8189"}'>{{options[index]}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 40rpx","borderColor":"#49a2af","alignItems":"center","display":"flex","minHeight":"100rpx","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
				<xia-editor :style='{"minHeight":"240rpx","padding":"20rpx 20rpx","margin":"0px","color":"#4a8189","flex":"1","background":"rgba(255, 255, 255, 0)","height":"auto"}' v-model="forum.content" @editorChange="contentChange" placeholder="内容"></xia-editor>
			</view>
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}'>
				<button :style='{"padding":"0 40rpx","boxShadow":"0px 0px 0px #ccc","margin":"32rpx 20rpx","borderColor":"#0bd9ed","color":"#0bd9ed","minWidth":"240rpx","borderRadius":"0px","background":"none","borderWidth":"2rpx 8rpx 2rpx","width":"auto","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"dashed","height":"80rpx"}' @tap="onSubmitTap" class="bg-red margin-tb-sm">确认提交</button>
			</view>
		</form>
	</view>
</view>
</template>

<script>
    import xiaEditor from '@/components/xia-editor/xia-editor';
	export default {
		data() {
			return {
				forum: {
					content: '',
					id: '',
					title: '',
					isdone: '开放',
					parentid: 0
				},
				index: 0,
				options: ['开放', '关闭'],
				username: '',
				user: {}
			}
		},
        components: {
            xiaEditor
        },
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
            if(table == `yonghu`){
                this.username = this.user.yonghuming
            }
			if (options.id) {
				this.id = options.id;
				let res = await this.$api.info('forum',this.id);
				this.forum = res.data
			}
			this.styleChange()
		},
		methods: {
            contentChange(e) {
                this.forum.content = e
            },
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.my-publish-pv .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.myPublishForm.content.input.backgroundColor
					// })
				})
			},
			async onSubmitTap() {
				this.forum.username = this.username;
				if (this.id) {
					await this.$api.update('forum',this.forum);
				} else {
					await this.$api.save('forum',this.forum);
				}
				this.$utils.msgBack('操作成功');
			},
			setIsDoneTap(e) {
				// this.forum.isdone = e;
				this.index = e.target.value
				this.forum.isdone = this.options[this.index]
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
