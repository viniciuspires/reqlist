'use strict';

var app = angular.module('reqlist', ['ngRoute','ngAnimate','localytics.directives']);

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
	
	//$locationProvider.html5Mode(true);
	
}).filter('numberPad', function() {
	return function(input, minNumberOfDigits) {
		minNumberOfDigits = minNumberOfDigits || 2;
		input = input + '';
		var zeros = new Array(minNumberOfDigits - input.length + 1).join('0');
		return zeros + input;
	};
}).service('ProjetoService', function($http) {
	this.findAll = function() {
		return $http.get('api/projeto');
	};
	this.getProjeto = function(id){
		return $http.get('api/projeto/'+id);
	};
	this.persist = function(projeto) {
		if ( projeto.id !== null ) {
			return $http.put('api/projeto/'+projeto.id, projeto);
		} else {
			return $http.post('api/projeto', projeto);
		}
	};
	this.arquivar = function(projeto){
		return $http.delete('api/projeto/'+projeto.id);
	};
	this.getAndamento = function(projeto) {
		return $http.get('api/projeto/'+projeto.id+'/andamento');
	};
	this.getComparacao = function() {
		return $http.get('api/projeto/comparacao');
	};
}).service('EscopoService', function($http){
	this.getEscoposByProjeto = function(projeto){
		return $http.get('api/projeto/'+projeto.id+'/escopo');
	};
	
	this.getBurndown = function(projeto, escopo) {
		return $http.get('api/projeto/'+projeto.id+'/escopo/'+escopo.id+'/burndown');
	};
}).directive('menuNavegacao', function(){
	return {
		templateUrl:'directive/menu-navegacao.html',
		link:function(scope, element, attrs){
			scope.selected = attrs.menuNavegacao;
			
			scope.horizontal = attrs.horizontal !== undefined;
		}
	};
}).directive('title', function($timeout){
	return function(scope, element, attrs){
		if (attrs.toggle === undefined) {
			attrs.toggle = 'tooltip';
		}
		if (attrs.placement === undefined) {
			attrs.placement = 'top';
		}
		
		$timeout(function(){
			element.tooltip();
		});
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
	ProjetoListController:function($scope, $window, ProjetoService){
		$scope.projetos = [];
		
		ProjetoService.findAll().then(function(response){
			$scope.projetos = response.data;
		}, function(response){
			console.log(response);
			$window.alert("Não foi possível buscar os projetos: " + response.statusText + " ("+response.status+")");
		});

		$scope.removerProjeto = function(projeto){
			if ( window.confirm('Tem certeza que deseja arquivar este projeto?') ) {

			}
		};
	},
	ProjetoController:function($scope, $routeParams, EscopoService, $window){
		$scope.projeto = {
			id:$routeParams.idProjeto
		};
		$scope.escopos = [];
		
		EscopoService.getEscoposByProjeto($scope.projeto).then(function(response){
			$scope.escopos = response.data;
		}, function(response){
			console.log(response);
			$window.alert("Não foi possível buscar os escopos: " + response.statusText + " ("+response.status+")");
		});
		
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
	BurndownController:function($scope, $routeParams, EscopoService, $filter, $window){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
		$scope.burndown = {};
		
		EscopoService.getBurndown({id:$scope.idProjeto}, {id:$scope.idEscopo}).then(function(response){
			$scope.burndown = response.data;
			console.log($scope.burndown);
			
			var categories = $scope.burndown.estimativa.map(function(element){
				var data = new Date( element.finalizacao );
				return $filter('date')(data, 'dd/MM');
			});
			
			var tarefasRestantes = $scope.burndown.totalTarefas;
			
			var planejamento = $scope.burndown.planejamento.map(function(element){
				tarefasRestantes -= element.tarefasConcluidas;
				return tarefasRestantes;
			});
			
			var tarefasRestantes = $scope.burndown.totalTarefas;
			
			var realizacao = $scope.burndown.realizacao.map(function(element){
				tarefasRestantes -= element.tarefasConcluidas;
				return tarefasRestantes;
			});
			
			var tarefasRestantes = $scope.burndown.totalTarefas;
			
			var estimativa = $scope.burndown.estimativa.map(function(element){
				tarefasRestantes -= element.tarefasConcluidas;
				return tarefasRestantes;
			});
			
			$('#burndown').highcharts({
				title: {
					text:'Burndown de tarefas'
				},
				chart: {
					type: 'spline',
					backgroundColor:null
				},
				xAxis: {
					categories: categories
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
						name: 'Planejamento',
						color: '#3276B1',
						data: planejamento,
						type: 'areaspline'
					},
					{
						name: 'Realização',
						color: '#5CB85C',
						data: realizacao
					},
					{
						name: 'Projeção',
						color:'#D9534F',
						data: estimativa,
						type: 'spline'
					}
				]
			});
			
		}, function(response){
			console.log(response);
			$window.alert("Não foi possível buscar o burndown do projeto: "
				+ response.statusText + " ("+response.status+")");
		});
	},
	AndamentoController:function($scope, $routeParams, ProjetoService, $window){
		$scope.projeto = {
			id: $routeParams.idProjeto
		};
		
		$scope.escopos = [];
		
		ProjetoService.getAndamento($scope.projeto).then(function(response){
			$scope.escopos = response.data.escopos;
		}, function(response){
			console.log(response);
			$window.alert("Não foi possível buscar o andamento do projeto: " + response.statusText + " ("+response.status+")");
		});
		
		$scope.porcentagem = function(parte, todo){
			return parte/todo*100;
		};
	},
	ComparacaoController:function($scope, $window, ProjetoService){
		$scope.comparacao = {};
		
		ProjetoService.getComparacao().then(function(response){
			$scope.comparacao = response.data;
			console.log($scope.comparacao);
			
			var categories = $scope.comparacao.projetos.map(function(projeto){
				return projeto.nome;
			});
			var planejado = $scope.comparacao.projetos.map(function(projeto){
				return projeto.horasPlanejadas;
			});
			var realizado = $scope.comparacao.projetos.map(function(projeto){
				return projeto.horasRealizadas;
			});
			var razao = $scope.comparacao.projetos.map(function(projeto){
				return (projeto.horasRealizadas / projeto.horasPlanejadas) * 100;
			});
			
			$('#comparacao').highcharts({
				chart:{
					zoomType: 'xy',
					backgroundColor:null
				},
				title:false,
				xAxis: {
					categories: categories,
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
					format:'{y}% batata',
					min:0,
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
						data: planejado
					},
					{
						type:'column',
						name:'Realizado',
						data: realizado
					},
					{
						type:'spline',
						name:'Razão',
						yAxis:1,
						data: razao
					}
				]
			});
			
		}, function(response){
			console.log(response);
			$window.alert("Não foi possível buscar a comparação dos projetos: "
				+ response.statusText + " ("+response.status+")");
		});
	},
	RequisitoController:function($scope, $routeParams, $window){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
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