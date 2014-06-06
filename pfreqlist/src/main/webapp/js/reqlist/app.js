'use strict';

var app = angular.module('reqlist', ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
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
	}).when('/projeto/:idProjeto/escopo/:idEscopo/burndown', {
		templateUrl:'view/projeto-burndown.html',
		controller:'BurndownController'
	}).when('/projeto/:idProjeto/andamento', {
		templateUrl:'view/projeto-andamento.html',
		controller:'AndamentoController'
	}).when('/projeto/:idProjeto/escopo/:idEscopo/requisito', {
		templateUrl:'view/requisito-list.html',
		controller:'RequisitoController'
	}).when('/projeto/:idProjeto/escopo/:idEscopo/tarefa', {
		templateUrl:'view/tarefa-list.html',
		controller:'TarefaController'
	}).when('/projeto/:idProjeto/escopo/:idEscopo/alocacao', {
		templateUrl:'view/alocacao.html',
		controller:'AlocacaoController'
	}).when('/projeto/:idProjeto/escopo/:idEscopo/objetivo', {
		templateUrl:'view/objetivo-list.html',
		controller:'ObjetivoController'
	}).when('/projeto/:idProjeto/escopo/:idEscopo/entrega', {
		templateUrl:'view/entrega.html',
		controller:'EntregaController'
	}).when('/usuario/:idUsuario', {
		templateUrl:'view/usuario-detail.html',
		controller:'UsuarioController'
	}).when('/usuario/:idUsuario/edit', {
		templateUrl:'view/usuario-edit.html',
		controller:'UsuarioController'
	}).otherwise({
		redirectTo:'/projeto'
	});
	
	$locationProvider.html5Mode(true);
	
}).service('ProjetoService', function($http) {
	this.findAll = function() {
		return [];
	};
	this.getProjeto = function(id){
		return {};
	};
	this.persist = function(projeto) {
		if ( projeto.id !== null ) {

		} else {

		}
	};
	this.getAndamento = function(projeto) {

	};
	this.getBurndown = function(projeto) {

	};
	this.getComparacao = function(projeto) {

	};
}).directive('menuNavegacao', function(){
	return {
		templateUrl:'directive/menu-navegacao.html',
		link:function(scope, element, attrs){
			scope.selected = attrs.menuNavegacao;
			
			scope.horizontal = attrs.horizontal !== undefined;
		}
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
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...'
			},
			{
				id:2,
				titulo:'Sistema de Controle de Colaboradores',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...'
			},
			{
				id:3,
				titulo:'CRM Cliente Acme',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...'
			},
			{
				id:4,
				titulo:'Reqlist',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...'
			},
			{
				id:5,
				titulo:'Sistema de Controle de Estoque',
				descricao:'O sistema de pagamento começou com a necessidade de manter um histórico de folhas da empresa X, ...'
			}
		];

		$scope.removerProjeto = function(projeto){
			if ( window.confirm('Tem certeza que deseja arquivar este projeto?') ) {

			}
		};
	},
	ProjetoController:function($scope, $routeParams, ProjetoService, $window){
		$scope.escopos = [
			{
				id:1,
				titulo:'Primeira versão (v1.0)',
				data:'12/10/1990'
			},
			{
				id:2,
				titulo:'Versão Alpha (v0.1)',
				data:'29/05/1987'
			},
			{
				id:3,
				titulo:'Beta testing (v0.2)',
				data:'22/11/1989'
			}
		];
		
		$scope.travarEscopo = function(escopo){
			var confirmMessage = "Após travar o escopo, só será possível"
				+" alterar o projeto atráves de um novo escopo.\n\n"
				+" Deseja realmente travar o escopo?";
			if ($window.confirm(confirmMessage)) {
				
			}
		};
		$scope.copiarEscopo = function(escopo) {
			if ( $window.confirm("Tem certeza que deseja copiar o escopo?") ) {
				
			}
		};
		$scope.removerEscopo = function(escopo){
			if ( $window.confirm("Tem certeza que deseja remover o escopo?") ) {
				
			}
		};
		
		// Widget usuários do projeto
		$scope.usuarios = [
			{
				nome:'Vinicius da Costa Pires',
				email:'',
				avatar:'//gravatar.com/avatar/6bb8d259b6b46a59ec66aadbd2b13015?s=40',
				perfil:{
					nome:'Administrador',
					classe:'primary'
				}
			},
			{
				nome:'Iran Sousa de Freitas',
				email:'',
				avatar:'//gravatar.com/avatar/36bb355a5f3ef6df2644c42f17e804eb?s=40',
				perfil:{
					nome:'Prestador',
					classe:'default'
				}
			},
			{
				nome:'Fulano da Silva Sauro',
				email:'',
				avatar:'//placehold.it/40x40',
				perfil:{
					nome:'Cliente',
					classe:'success'
				}
			}
		];
		
		$scope.removerUsuario = function(usuario) {
			var primeiroNome = usuario.nome.split(" ")[0];
			var mensagem = "Tem certeza que deseja remover o "
				+usuario.perfil.nome.toLowerCase() + " " +primeiroNome+"?";
			if ($window.confirm(mensagem)) {
			}
		};
	},
	ProjetoFormController:function($scope, $routeParams, ProjetoService){

	},
	BurndownController:function($scope, $routeParams){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
		$('#burndown').highcharts({
			title: {
				text:'Burndown de tarefas'
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
					'28/10'
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
					type: 'areaspline'
				},
				{
					name: 'Real',
					color: '#5CB85C',
					data: [30, 30, 28, 23, 22, 20, 20, 19, 17, 15, 13, 7]
				},
				{
					name: 'Projeção',
					color:'#D9534F',
					data: [30, 28, 26, 24, 22, 20, 18, 16, 14, 12, 10, 8, 6, 4, 2, 0],
					type: 'spline'
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
					data:[115, 110, 90, 60]
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
	RequisitoController:function($scope, $routeParams, $window){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		$('[data-chosen]').chosen();
		
		$scope.removerRequisito = function(requisito){
			if ($window.confirm("Deseja remover o requisito?")) {
				
			}
		};
	},
	TarefaController:function($scope, $routeParams, $window){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
		$scope.removerTarefa = function(tarefa){
			if ($window.confirm("Deseja remover a tarefa?")) {
				
			}
		};
		$scope.alterarResponsavel = function(tarefa){
			if ($window.confirm("Deseja se tornar responsável pela tarefa?")) {
				
			}
		};
	},
	AlocacaoController:function($scope, $routeParams, $timeout){
		$timeout(function(){
			$('[data-calendar]').fullCalendar({
				header: {
					left:'prev,next today',
					right:'month,agendaWeek,agendaDay'
				},
				defaultView:'agendaWeek',
				editable: true,
				start:new Date(),
				weekNumbers:true
			});
			$('[data-draggable]').draggable({revert:true,helper:'clone'});
			$('[data-droppable]').droppable();
		});
		$scope.tipoAlocacao = "planejado"; // realizado
		
		$scope.$watch('tipoAlocacao', function(valorNovo){
			// TODO buscar alocação do tipo
		});
		
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
	},
	ObjetivoController:function($scope, $routeParams, $window){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
		$scope.removerObjetivo = function(objetivo){
			if ($window.confirm("Tem certeza que deseja remover o objetivo?")) {
				
			}
		};
	},
	EntregaController:function($scope, $routeParams, $window){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
		$('[data-draggable]').draggable({revert:true,helper:'clone',opacity:0.8});
		$('[data-droppable]').droppable();
		
		$scope.removerEntrega = function(entrega){
			if ($window.confirm("Deseja remover a entrega?")) {
				
			}
		};
	},
	UsuarioController:function($scope, $routeParams){
		$scope.idUsuario = $routeParams.idUsuario;
	}
});


$(document).ready(function(){
	$('[data-tooltip]').tooltip();
	$('[data-chosen]').chosen({width:'100%'});
	$('[data-draggable]').draggable({revert:true});
	$('[data-droppable]').droppable();
});