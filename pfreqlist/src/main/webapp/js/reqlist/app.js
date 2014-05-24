var app = angular.module('reqlist', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider.when('/projeto', {
		templateUrl:'view/projeto-list.html',
		controller:'ProjetoListController'
	}).when('/projeto/new', {
		templateUrl:'view/projeto-form.html',
		controller:'ProjetoFormController'
	}).when('/projeto/comparacao', {
		templateUrl:'view/comparacao.html',
		controller:'ComparacaoController'
	}).when('/projeto/:idProjeto', {
		templateUrl:'view/projeto-detail.html',
		controller:'ProjetoController'
	}).when('/projeto/:idProjeto/edit', {
		templateUrl:'view/projeto-form.html',
		controller:'ProjetoFormController'
	}).when('/projeto/:idProjeto/burndown', {
		templateUrl:'view/projeto-burndown.html',
		controller:'BurndownController'
	}).when('/projeto/:idProjeto/andamento', {
		templateUrl:'view/projeto-andamento.html',
		controller:'AndamentoController'
	}).when('/projeto/:idProjeto/requisitos', {
		templateUrl:'requisitos',
		controller:'RequisitoController'
	}).when('/projeto/:idProjeto/tarefas', {
		templateUrl:'view/tarefa-list.html',
		controller:'TarefaController'
	}).when('/projeto/:idProjeto/alocacao', {
		templateUrl:'view/alocacao.html',
		controller:'AlocacaoController'
	}).otherwise({
		redirectTo:'/projeto'
	});
}).service('ProjetoService', function($http) {
	this.findAll = function() {
		return [];
	};
	this.getProjeto = function(id){
		return {};
	};
	this.persist = function(projeto) {
		if ( projeto.id != null ) {

		} else {

		}
	};
	this.getAndamento = function(projeto) {

	};
	this.getBurndown = function(projeto) {

	};
	this.getComparacao = function(projeto) {

	};
}).controller({
	MenuController:function($scope) {
		$scope.modules = [
			{
				nome:"Projeto",
				url:""
			},
			{
				nome:"",
				url:""
			},
			{
				nome:"",
				url:""
			},
			{
				nome:"",
				url:""
			}
		];
	},
	ProjetoListController:function($scope, $routeParams, ProjetoService){
		$scope.projetos = [
			{
				id:1,
				titulo:'Sistema de Folha de Pagamento',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...',
			},
			{
				id:2,
				titulo:'Sistema de Controle de Colaboradores',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...',
			},
			{
				id:3,
				titulo:'CRM Cliente Acme',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...',
			},
			{
				id:4,
				titulo:'Reqlist',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...',
			},
			{
				id:5,
				titulo:'Sistema de Controle de Estoque',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...',
			}
		];

		$scope.removerProjeto = function(projeto){
			if ( window.confirm('Tem certeza que deseja arquivar este projeto?') ) {

			}
		};
	},
	ProjetoController:function($scope, $routeParams, ProjetoService){

	},
	ProjetoFormController:function($scope, $routeParams, ProjetoService){

	},
	BurndownController:function($scope, $routeParams){
		$('#burndown').highcharts({
			title: {
				text:'',
			},
			chart: {
				type: 'spline',
				backgroundColor:null
			},
			xAxis: {
				categories: [
					'7/10',
					'8/10',
					'9/10',
					'10/10',
					'11/10',
					'14/10',
					'15/10',
					'16/10',
					'17/10',
					'18/10',
					'21/10',
					'22/10',
					'23/10',
					'24/10',
					'25/10',
					'28/10',
				]
			},
			credits: false,
			yAxis: {
				title: {
					text: 'Número de tarefas restantes'
				},
				plotLines: [{
					value: 0,
					width: 1,
					color: '#808080'
				}]
			},
			tooltip: {
				valueSuffix: ' tarefas restantes',
				shared:true
			},
			legend: {
				layout: 'horizontal',
				align: 'center',
				verticalAlign: 'bottom',
				borderWidth: 0
			},
			series: [
				{
					name: 'Estimativa',
					color: '#3276B1',
					data: [30, 25, 21, 19, 18, 15, 11, 10, 9, 5, 2, 0],
					type: 'areaspline',
				},
				{
					name: 'Real',
					color: '#5CB85C',
					data: [30, 30, 28, 23, 22, 20, 20, 19, 17, 15, 13, 7],
				},
				{
					name: 'Projeção',
					color:'#D9534F',
					data: [30, 28, 26, 24, 22, 20, 18, 16, 14, 12, 10, 8, 6, 4, 2, 0],
					type: 'spline',
				}
			]
		});
	},
	AndamentoController:function($scope, $routeParams){

	},
	ComparacaoController:function($scope, $routeParams){
		$('#comparacao').highcharts({
			chart:{
				zoomType: 'xy',
				backgroundColor:null
			},
			title:false,
			xAxis: {
				categories: [
					'Folha de Pagamento',
					'Controle de Estoque',
					'Fluxo de Caixa',
					'Reqlist'
				],
				labels: {
					align: 'center',
					style: {
						fontSize: '0.9em',
						fontFamily: 'Verdana, sans-serif'
					}
				}
			},
			yAxis: [{
				title: {
					text:'Horas estimadas x utilizadas'
				},
				labels:{
					format:'{value}h'
				}
			},
			{
				title: {
					text:'Razão (%)'
				},
				labels:{
					format:'{value}%'
				},
				format:'{y}%',
				opposite:true
			}],
			credits:{
				enabled:false
			},
			legend: {
				layout: 'horizontal',
				align: 'center',
				verticalAlign: 'bottom',
				borderWidth: 0
			},
			tooltip: {
				shared:true
			},
			series: [
				{
					type:'column',
					name:'Planejado',
					data:[115, 110, 90, 60],
				},
				{
					type:'column',
					name:'Realizado',
					data:[150, 178, 58, 59]
				},
				{
					type:'spline',
					name:'Razão',
					yAxis:1,
					data:[130.43, 161.82, 64.44, 98.33]
				}
			]
		});
	},
	RequisitoController:function($scope, $routeParams){

	},
	TarefaController:function($scope){
		
	},
	AlocacaoController:function($scope){
		$('[data-calendar]').fullCalendar({
			header: {
				left:'prev,next today',
				right:'month,basicWeek'
			},
			editable: true,
		});
	}
});


$(document).ready(function(){
	$('[data-tooltip]').tooltip();
	$('[data-chosen]').chosen();
	$('[data-draggable]').draggable({revert:true});
	$('[data-droppable]').droppable();
});