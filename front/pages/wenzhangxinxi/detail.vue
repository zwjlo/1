
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"minHeight":"100vh","width":"100%","padding":"40rpx 0 132rpx","position":"relative","background":"url(http://codegen.caihongy.cn/20221224/7e3cf68e360446639633a87989cda19c.gif) no-repeat center top / 100% auto,#192231","height":"auto"}'>
						<swiper :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"0px 0 0px ","margin":"0px auto","borderColor":"#0bd9ed","borderRadius":"10%","background":"rgba(11,217,237,.1)","borderWidth":"8rpx","width":"calc(100% - 40rpx)","borderStyle":"groove","height":"420rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","borderRadius":"0px 0px 10% 10%","background":"none","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"calc(100% - 40rpx)","margin":"16rpx auto","objectFit":"cover","borderRadius":"10%","display":"block","height":"360rpx"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></image>
					<image :style='{"width":"calc(100% - 40rpx)","margin":"16rpx auto","objectFit":"cover","borderRadius":"10%","display":"block","height":"360rpx"}' mode="aspectFill" v-else :src="baseUrl+swiper"></image>
				</swiper-item>
			</swiper>
									            <view :style='{"padding":"0px 24rpx 24rpx","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="detail-content">
				<view :style='{"padding":"0px 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"40rpx 0 24rpx 0","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","justifyContent":"space-between","height":"88rpx"}' class="detail-list-item price priceFavor">
					<view :style='{"border":"0px solid #e9be70","boxShadow":"0px 0px 0px #ccc","margin":"0px 12rpx 0","color":"#fec55d","textAlign":"center","display":"block","borderRadius":"100%","background":"none","width":"64rpx","lineHeight":"80rpx","fontSize":"48rpx","textShadow":"0px 0px 0px #ccc","height":"64rpx"}' v-if="storeupFlag==1" class="cuIcon-favorfill" @click="shoucang"></view>
					<view :style='{"border":"0px solid #e9be70","boxShadow":"0px 0px 0px #ccc","margin":"0px 12rpx 0","color":"#fec55d","textAlign":"center","display":"block","borderRadius":"100%","background":"none","width":"64rpx","lineHeight":"80rpx","fontSize":"48rpx","textShadow":"0px 0px 0px #ccc","height":"64rpx"}' v-if="storeupFlag==0" class="cuIcon-favor" @click="shoucang"></view>
				</view>

				<view :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"16rpx 40rpx","margin":"20rpx 0 20rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}' class="lable">文章标题：</view>
					<view :style='{"width":"100%","padding":"0px 20rpx 20rpx 0","margin":"0px 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#4a8189"}' class="text">{{detail.wenzhangbiaoti}}</view>
				</view>
				<view :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"16rpx 40rpx","margin":"20rpx 0 20rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}' class="lable">标签：</view>
					<view :style='{"width":"100%","padding":"0px 20rpx 20rpx 0","margin":"0px 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#4a8189"}' class="text">{{detail.biaoqian}}</view>
				</view>

				<view class="detail-list-item" :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"16rpx 40rpx","margin":"20rpx 0 20rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
					<view class="lable" :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}'>文章分类：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px 20rpx 20rpx 0","margin":"0px 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#4a8189"}'>{{detail.wenzhangfenlei}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"16rpx 40rpx","margin":"20rpx 0 20rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
					<view class="lable" :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}'>用户名：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px 20rpx 20rpx 0","margin":"0px 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#4a8189"}'>{{detail.yonghuming}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"16rpx 40rpx","margin":"20rpx 0 20rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
					<view class="lable" :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}'>发布人：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px 20rpx 20rpx 0","margin":"0px 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#4a8189"}'>{{detail.xingming}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"16rpx 40rpx","margin":"20rpx 0 20rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
					<view class="lable" :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}'>发布时间：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px 20rpx 20rpx 0","margin":"0px 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#4a8189"}'>{{detail.fabushijian}}</view>
				</view>
				<view class="detail-list-item" :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"16rpx 40rpx","margin":"20rpx 0 20rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
					<view class="lable" :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}'>点击次数：</view>
					<view  class="text" :style='{"width":"100%","padding":"0px 20rpx 20rpx 0","margin":"0px 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#4a8189"}'>{{detail.clicknum}}</view>
				</view>

				<view :style='{"padding":"0 24rpx 8rpx 0","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 24rpx 0","borderColor":"#49a2af","borderRadius":"0","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"48%","borderStyle":"dotted dashed groove","height":"auto"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"right"}' class="lable">赞：</view>
					<view :style='{"width":"100%","flex":"1","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"color":"#35afc0","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"border":"0px solid #1bd0a9","boxShadow":"0px 0px 0px #afd3cc","color":"#35afc0","borderRadius":"80rpx","textAlign":"center","background":"none","width":"72rpx","lineHeight":"72rpx","fontSize":"40rpx","textShadow":"0px 0px 0px #75afa2","height":"72rpx"}' class="cuIcon-appreciate" @click="zan"></view>
					</view>
				</view>
				<view :style='{"padding":"0 24rpx 8rpx 0","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 24rpx 0","borderColor":"#49a2af","borderRadius":"0","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"48%","borderStyle":"dotted dashed groove","height":"auto"}' class="detail-list-item" v-if="thumbsupFlag">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"right"}' class="lable">已赞：</view>
					<view :style='{"width":"100%","flex":"1","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"color":"#35afc0","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"border":"0px solid #1bd0a9","boxShadow":"0px 0px 0px #afd3cc","color":"#35afc0","borderRadius":"80rpx","textAlign":"center","background":"none","width":"72rpx","lineHeight":"72rpx","fontSize":"40rpx","textShadow":"0px 0px 0px #75afa2","height":"72rpx"}' class="cuIcon-appreciate" @click="zan"></view>
					</view>
				</view>
				<view :style='{"padding":"0 24rpx 8rpx 0","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 24rpx 0","borderColor":"#49a2af","borderRadius":"0","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"48%","borderStyle":"dotted dashed groove","height":"auto"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"right"}' class="lable">踩：</view>
					<view :style='{"width":"100%","flex":"1","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"color":"#35afc0","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.crazilynum}}</view>
						<view style="transform: rotate(180deg);" :style='{"border":"0px solid #1bd0a9","boxShadow":"0px 0px 0px #afd3cc","color":"#35afc0","borderRadius":"100%","textAlign":"center","background":"none","width":"72rpx","lineHeight":"72rpx","fontSize":"40rpx","textShadow":"0px 0px 0px #75afa2","height":"72rpx"}' class="cuIcon-appreciate" @click="cai"></view>
					</view>
				</view>
				<view :style='{"padding":"0 24rpx 8rpx 0","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 24rpx 0","borderColor":"#49a2af","borderRadius":"0","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"48%","borderStyle":"dotted dashed groove","height":"auto"}' class="detail-list-item" v-if="crazilyFlag">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"right"}' class="lable">踩：</view>
					<view :style='{"width":"100%","flex":"1","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"color":"#35afc0","lineHeight":"80rpx","fontSize":"28rpx"}'>{{detail.crazilynum}}</view>
						<view style="transform: rotate(180deg);" :style='{"border":"0px solid #1bd0a9","boxShadow":"0px 0px 0px #afd3cc","color":"#35afc0","borderRadius":"100%","textAlign":"center","background":"none","width":"72rpx","lineHeight":"72rpx","fontSize":"40rpx","textShadow":"0px 0px 0px #75afa2","height":"72rpx"}' class="cuIcon-appreciate" @click="cai"></view>
					</view>
				</view>




				<view class="detail-list-item rich" :style='{"boxShadow":"inset 0px 0px 0px 0px #f9edd9","padding":"24rpx 24rpx","margin":"0 0 24rpx 0","borderColor":"#49a2af","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}'>
					<view class="lable" :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#35afc0","textAlign":"left"}'>博文内容</view>
					<view class="rich-text" :style='{"minHeight":"240rpx","border":"0px solid #f7de91","padding":"0 20rpx 0 0","boxShadow":"0 0px 0px rgba(182,158,18,.4),inset 0px 0px 0px 0px #fcf6d6","margin":"0","borderRadius":"8rpx","color":"#4a8189","background":"none","width":"100%","lineHeight":"48rpx","textIndent":"2em"}'>
						<rich-text :nodes="detail.bowenneirong"></rich-text>
					</view>
				</view>


				<view class="time-content" :style='{"width":"100%","margin":"24rpx 0 24rpx 0","background":"url(http://codegen.caihongy.cn/20221224/7e3cf68e360446639633a87989cda19c.gif) no-repeat center bottom / 100% auto","height":"auto"}'>
					<view class="comoment-header" :style='{"border":"0px solid #fdd802","boxShadow":"inset 0px 0px 0px 0px #fcf3bf","padding":"0px 20rpx","margin":"0px","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221224/a7a84be25ba14876b37b435e06e66737.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221224/9795faa3c16747b7ae6a02b3ee80bae3.png) no-repeat center bottom / 100% auto,url(http://codegen.caihongy.cn/20221224/0982a2f10bee4481a22d37de1faea15d.png) repeat-y center center / 100% auto","display":"flex","width":"calc(100% + 0px)","justifyContent":"space-between","height":"auto"}'>
						<view :style='{"padding":"40rpx 20rpx 20rpx","lineHeight":"100rpx","fontSize":"28rpx","color":"#35afc0"}'>评论</view>
						<view :style='{"border":"0px solid #64b7ea","padding":"0 16rpx 0 4rpx","margin":"64rpx 16rpx 12rpx ","borderRadius":"12rpx","background":"none","display":"flex","height":"64rpx"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0px 8rpx 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#35afc0"}' class="cuIcon-add"></view>
							<view :style='{"margin":"0px 0 0","lineHeight":"60rpx","fontSize":"28rpx","color":"#35afc0"}'>添加评论</view>
						</view>
					</view>
				
					<view :style='{"padding":"24rpx 24rpx 40rpx","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"32rpx 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","background":"none","borderWidth":"0px 0px 8rpx 0px","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"width":"100%","display":"flex","height":"auto"}'>
							<image :style='{"width":"60rpx","margin":"0 8rpx 0 0","borderRadius":"8rpx","display":"block","height":"60rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"color":"#35afc0","lineHeight":"60rpx","fontSize":"28rpx"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"padding":"20rpx","margin":"24rpx 0","color":"#4a8189","borderRadius":"24rpx","background":"rgba(105,213,223,.1)","lineHeight":"1.5","fontSize":"28rpx","textIndent":"2em"}' class="text-gray text-content text-df">
							{{item.content}}
						</view>
						<view :style='{"lineHeight":"24rpx","fontSize":"24rpx","color":"#4a8189","textAlign":"right"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"padding":"20rpx","margin":"24rpx 0","color":"#4a8189","borderRadius":"24rpx","background":"rgba(105,213,223,.1)","lineHeight":"1.5","fontSize":"28rpx","textIndent":"2em"}' class="text-gray text-content text-df">
							回复:{{item.reply}}
						</view>
					</view>
				</view>

				<view class="bottom-content bg-white tabbar border shop" :style='{"width":"100%","padding":"20rpx 0px","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'>

					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"rgb(255, 170, 51)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="userid&&isAuth('wenzhangxinxi','举报')" @tap="onAcrossTap('jubaoxinxi','','[1]','已进行举报！')" class="cu-btn bg-brown round shadow-blur" >举报</button>
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0","color":"rgb(255, 255, 255)","background":"rgb(255, 170, 51)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('wenzhangxinxi','举报')" @tap="onAcrossTap('jubaoxinxi','','[1]','已进行举报！')" class="cu-btn bg-brown round shadow-blur" >举报</button>
				</view>
			</view>

		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				storeupFlag: 0,
				thumbsupFlag: 0,
				crazilyFlag: 0,
				count: 0,
				timer: null
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			SecondToDate: function() {
				var time = this.count;
				if (null != time && "" != time) {
					if (time > 60 && time < 60 * 60) {
						time =
							parseInt(time / 60.0) +
							"分钟" +
							parseInt((parseFloat(time / 60.0) - parseInt(time / 60.0)) * 60) +
							"秒";
					} else if (time >= 60 * 60 && time < 60 * 60 * 24) {
						time =
							parseInt(time / 3600.0) +
							"小时" +
							parseInt(
								(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
							) +
							"分钟" +
							parseInt(
								(parseFloat(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									) -
									parseInt(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									)) *
								60
							) +
							"秒";
					} else if (time >= 60 * 60 * 24) {
						time =
							parseInt(time / 3600.0 / 24) +
							"天" +
							parseInt(
								(parseFloat(time / 3600.0 / 24) - parseInt(time / 3600.0 / 24)) *
								24
							) +
							"小时" +
							parseInt(
								(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
							) +
							"分钟" +
							parseInt(
								(parseFloat(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									) -
									parseInt(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									)) *
								60
							) +
							"秒";
					} else {
						time = parseInt(time) + "秒";
					}
				}
				return time;
			}
		},
		async onLoad(options) {
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
		},
		async onShow(options) {
			// 渲染数据
			this.init();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.getStoreup();
			this.getThumbsup();
			let cleanType = uni.getStorageSync('discusswenzhangxinxiCleanType')
			if(cleanType){
				uni.removeStorageSync('discusswenzhangxinxiCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
			}
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 支付
			onPayTap(){
				uni.setStorageSync('paytable','wenzhangxinxi');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 收藏
			async getStoreup() {
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'wenzhangxinxi',
					userid: this.user.id,
					type: 1,
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'wenzhangxinxi',
					userid: _this.user.id,
					type: 1,
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.wenzhangbiaoti,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'wenzhangxinxi',
                                type: 1
							});
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				uni.setStorageSync('crossTable','wenzhangxinxi');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(){
				let res = await this.$api.info('wenzhangxinxi', this.id);
				this.detail = res.data;
				// 轮播图片
				this.swiperList = this.detail.fengmian ? this.detail.fengmian.split(",") : [];
				//修改富文本的图片样式
				this.detail.bowenneirong = this.detail.bowenneirong.replace(/img src/gi,"img style=\"width:100%;\" src");
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
                let res = await this.$api.list('discusswenzhangxinxi', {
					page: mescroll.num,
					limit: 10,
					refid: this.id
				});
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.commentList = [];
				this.commentList = this.commentList.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				this.$utils.jump(`../discusswenzhangxinxi/add-or-update?refid=${this.id}`)
			},
			// 获取赞踩
			async getThumbsup() {
				let params = {
					page: 1,
					limit: 1,
					refid: this.id,
					tablename: 'wenzhangxinxi',
					userid: this.user.id,
					type: '%2%',
				}
				let res = await this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					if(res.data.list[0].type=='21') {
						this.thumbsupFlag = 1;
					} else {
						this.crazilyFlag = 1;
					}
				}

			},
			// 点赞
			async zan() {
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename : 'wenzhangxinxi',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点赞',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) - 1;
								await _this.$api.update('wenzhangxinxi', _this.detail);
								_this.$utils.msg('取消成功');
								_this.thumbsupFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点赞',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
                                name: _this.detail.wenzhangbiaoti,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'wenzhangxinxi',
								type: '21'
							});
							_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) + 1;
							await _this.$api.update('wenzhangxinxi', _this.detail);
							_this.$utils.msg('点赞成功');
							_this.thumbsupFlag=1;
						}
					}
				});
			},
			// 踩
			async cai() {
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename: 'wenzhangxinxi',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点踩',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.crazilynum = parseInt(_this.detail.crazilynum) - 1;
								await _this.$api.update('wenzhangxinxi', _this.detail);
								_this.$utils.msg('取消成功');
								_this.crazilyFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点踩',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
                                name: _this.detail.wenzhangbiaoti,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'wenzhangxinxi',
								type: '22'
							});
							_this.detail.crazilynum = parseInt(_this.detail.crazilynum) + 1;
							await _this.$api.update('wenzhangxinxi', _this.detail);
							_this.$utils.msg('点踩成功');
							_this.crazilyFlag=1;
						}
					}
				});
			},
			onSHTap() {
				this.$refs.popup.open()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
</style>
