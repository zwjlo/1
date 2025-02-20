<template>
<view class="content">
	<view :style='{"minHeight":"100vh","padding":"260rpx 0 300rpx","borderColor":"#21d5ae","background":"url(http://codegen.caihongy.cn/20221223/47f4db5577fb492886b192809902163b.gif) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/ec4debd06eba457ca416dd1e20bdea56.gif) no-repeat left bottom / 100% auto,#192231","borderWidth":"0px 0 0","width":"100%","position":"relative","borderStyle":"dashed","height":"auto"}'>
		<form :style='{"width":"100%","padding":"60rpx 40rpx","background":"none","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"dotted dashed groove","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#0bd9ed","textAlign":"right"}' class="title">文章标题</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#4a8189","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx"}' :disabled="ro.wenzhangbiaoti" v-model="ruleForm.wenzhangbiaoti" placeholder="文章标题"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"dotted dashed groove","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#0bd9ed","textAlign":"right"}' class="title">文章分类</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="wenzhangfenleiChange" :value="wenzhangfenleiIndex"  :range="wenzhangfenleiOptions">
					<view :style='{"color":"#4a8189","width":"100%","fontSize":"28rpx"}' class="uni-input">{{ruleForm.wenzhangfenlei?ruleForm.wenzhangfenlei:"请选择文章分类"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"dotted dashed groove","height":"auto"}' class="" @tap="fengmianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#0bd9ed","textAlign":"right"}' class="title">封面</view>
				<image :style='{"width":"72rpx","margin":"12rpx 0","borderRadius":"100%","objectFit":"cover","display":"block","height":"72rpx"}' class="avator" v-if="ruleForm.fengmian" :src="baseUrl+ruleForm.fengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"72rpx","margin":"12rpx 0","borderRadius":"100%","objectFit":"cover","display":"block","height":"72rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"dotted dashed groove","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#0bd9ed","textAlign":"right"}' class="title">标签</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#4a8189","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx"}' :disabled="ro.biaoqian" v-model="ruleForm.biaoqian" placeholder="标签"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"dotted dashed groove","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#0bd9ed","textAlign":"right"}' class="title">用户名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#4a8189","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx"}' :disabled="ro.yonghuming" v-model="ruleForm.yonghuming" placeholder="用户名"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"dotted dashed groove","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#0bd9ed","textAlign":"right"}' class="title">发布人</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#4a8189","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx"}' :disabled="ro.xingming" v-model="ruleForm.xingming" placeholder="发布人"></input>
			</view>
			<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 0 32rpx","borderColor":"#49a2af","borderRadius":"0px","borderWidth":"0px 0px 8rpx 0px","background":"none","display":"flex","width":"100%","lineHeight":"100rpx","borderStyle":"dotted dashed groove","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","fontSize":"28rpx","color":"#0bd9ed","textAlign":"right"}' class="title">发布时间</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"#4a8189","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx"}' v-model="ruleForm.fabushijian" placeholder="发布时间" @tap="toggleTab('fabushijian')"></input>
			</view>
			
			<!-- 否 -->
 

			
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#0bd9ed","fontWeight":"500"}' class="title">博文内容</view>
                <xia-editor :style='{"minHeight":"240rpx","padding":"24rpx 32rpx","boxShadow":"inset 0px 0px 0px 0px #f9edd9","borderColor":"#49a2af","borderRadius":"0px","color":"#4a8189","background":"none","borderWidth":"0px 0px 8rpx 0px","width":"100%","borderStyle":"dotted dashed groove","height":"auto"}' v-model="ruleForm.bowenneirong" placeholder="博文内容" @editorChange="bowenneirongChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","margin":"40rpx 0 0 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"padding":"0 40rpx","boxShadow":"0px 0px 0px #ccc","margin":"0 40rpx 0 0","borderColor":"#0bd9ed","color":"#0bd9ed","display":"inline","minWidth":"200rpx","borderRadius":"0px","background":"none","borderWidth":"2rpx 8rpx 2rpx","width":"auto","lineHeight":"72rpx","fontSize":"28rpx","borderStyle":"dashed","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="fabushijianConfirm" ref="fabushijian" themeColor="#333333"></w-picker>
		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				wenzhangbiaoti: '',
				wenzhangfenlei: '',
				fengmian: '',
				biaoqian: '',
				yonghuming: '',
				xingming: '',
				bowenneirong: '',
				fabushijian: '',
				},
				wenzhangfenleiOptions: [],
				wenzhangfenleiIndex: 0,
				// 登陆用户信息
				user: {},
                                ro:{
                                   wenzhangbiaoti : false,
                                   wenzhangfenlei : false,
                                   fengmian : false,
                                   biaoqian : false,
                                   yonghuming : false,
                                   xingming : false,
                                   bowenneirong : false,
                                   fabushijian : false,
                                   thumbsupnum : false,
                                   crazilynum : false,
                                   clicktime : false,
                                   clicknum : false,
                                },
			}
		},
		components: {
			wPicker,
            xiaEditor
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
            this.ruleForm.fabushijian = this.$utils.getCurDateTime();

			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.yonghuming = this.user.yonghuming
			this.ro.yonghuming = true;
			this.ruleForm.xingming = this.user.xingming
			this.ro.xingming = true;

            this.ro.fabushijian = true;

			// 下拉框
			res = await this.$api.option(`wenzhangfenlei`,`wenzhangfenlei`,{});
			this.wenzhangfenleiOptions = res.data;
            this.wenzhangfenleiOptions.unshift("请选择文章分类");

			// 如果有登陆，获取登陆后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`wenzhangxinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='wenzhangbiaoti'){
					this.ruleForm.wenzhangbiaoti = obj[o];
					this.ro.wenzhangbiaoti = true;
					continue;
					}
					if(o=='wenzhangfenlei'){
					this.ruleForm.wenzhangfenlei = obj[o];
					this.ro.wenzhangfenlei = true;
					continue;
					}
					if(o=='fengmian'){
					this.ruleForm.fengmian = obj[o].split(",")[0];
					this.ro.fengmian = true;
					continue;
					}
					if(o=='biaoqian'){
					this.ruleForm.biaoqian = obj[o];
					this.ro.biaoqian = true;
					continue;
					}
					if(o=='yonghuming'){
					this.ruleForm.yonghuming = obj[o];
					this.ro.yonghuming = true;
					continue;
					}
					if(o=='xingming'){
					this.ruleForm.xingming = obj[o];
					this.ro.xingming = true;
					continue;
					}
					if(o=='bowenneirong'){
					this.ruleForm.bowenneirong = obj[o];
					this.ro.bowenneirong = true;
					continue;
					}
					if(o=='fabushijian'){
					this.ruleForm.fabushijian = obj[o];
					this.ro.fabushijian = true;
					continue;
					}
					if(o=='thumbsupnum'){
					this.ruleForm.thumbsupnum = obj[o];
					this.ro.thumbsupnum = true;
					continue;
					}
					if(o=='crazilynum'){
					this.ruleForm.crazilynum = obj[o];
					this.ro.crazilynum = true;
					continue;
					}
					if(o=='clicktime'){
					this.ruleForm.clicktime = obj[o];
					this.ro.clicktime = true;
					continue;
					}
					if(o=='clicknum'){
					this.ruleForm.clicknum = obj[o];
					this.ro.clicknum = true;
					continue;
					}
				}
			}
			this.styleChange()
		},
		methods: {
            bowenneirongChange(e) {
                this.ruleForm.bowenneirong = e
            },
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			fabushijianConfirm(val) {
				console.log(val)
				this.ruleForm.fabushijian = val.result;
				this.$forceUpdate();
			},
			// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			wenzhangfenleiChange(e) {
				this.wenzhangfenleiIndex = e.target.value
				this.ruleForm.wenzhangfenlei = this.wenzhangfenleiOptions[this.wenzhangfenleiIndex]
			},

			fengmianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.fengmian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {

























//跨表计算判断
				var obj;
				if((!this.ruleForm.wenzhangbiaoti)){
					this.$utils.msg(`文章标题不能为空`);
					return
				}
				if((!this.ruleForm.wenzhangfenlei)){
					this.$utils.msg(`文章分类不能为空`);
					return
				}
				if((!this.ruleForm.biaoqian)){
					this.$utils.msg(`标签不能为空`);
					return
				}
				if(this.ruleForm.thumbsupnum&&(!this.$validate.isIntNumer(this.ruleForm.thumbsupnum))){
					this.$utils.msg(`赞应输入整数`);
					return
				}
				if(this.ruleForm.crazilynum&&(!this.$validate.isIntNumer(this.ruleForm.crazilynum))){
					this.$utils.msg(`踩应输入整数`);
					return
				}
				if(this.ruleForm.clicknum&&(!this.$validate.isIntNumer(this.ruleForm.clicknum))){
					this.$utils.msg(`点击次数应输入整数`);
					return
				}
				//更新跨表属性
			       var crossuserid;
			       var crossrefid;
			       var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('userid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`wenzhangxinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`wenzhangxinxi`, this.ruleForm);
						}else{
							await this.$api.add(`wenzhangxinxi`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`wenzhangxinxi`, this.ruleForm);
					}else{
						await this.$api.add(`wenzhangxinxi`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
