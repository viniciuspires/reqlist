'use strict';

var app = angular.module('reqlist', ['ngRoute','ngAnimate','localytics.directives']);

var standardErrorHandler = function(response){
	console.log(response);
	window.alert("Não foi possível realizar a operação: "
		+response.statusText
		+" ("+response.status+")");
};

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
}).service('ObjetivoService', function($http){
	this.getObjetivosByProjeto = function(projeto){
		return $http.get('api/projeto/'+projeto.id+'/objetivo');
	};
	this.persist = function(projeto, objetivo) {
		if ( objetivo.id !== null ) {
			return $http.put('api/projeto/'+projeto.id+'/objetivo/'+objetivo.id, objetivo);
		} else {
			return $http.post('api/projeto/'+projeto.id+'/objetivo', objetivo);
		}
	};
	this.getObjetivo = function(projeto, objetivo) {
		return $http.get('api/projeto/'+projeto.id+'/objetivo/'+objetivo.id+'/burndown');
	};
}).service('RequisitoService', function($http){
	this.getRequisitosByProjetoAndEscopo = function(projeto, escopo){
		return $http.get('api/projeto/'+projeto.id+'/escopo/'+escopo.id+'/requisito');
	};
	this.persist = function(projeto, escopo, requisito) {
		if ( requisito.id !== null ) {
			return $http.put('api/projeto/'+projeto.id+'/escopo/'+escopo.id
				+'/requisito/'+requisito.id, requisito);
		} else {
			return $http.post('api/projeto/'+projeto.id+'/escopo'+escopo.id
				+'/requisito', requisito);
		}
	};
	this.getRequisito = function(projeto, escopo, requisito) {
		return $http.get('api/projeto/'+projeto.id+'/escopo/'+escopo.id
			+'/requisito/'+requisito.id);
	};
}).service('TarefaService', function($http){
	this.getTarefasByProjetoAndEscopo = function(projeto, escopo){
		return $http.get('api/projeto/'+projeto.id+'/escopo/'+escopo.id+'/tarefa');
	};
	this.persist = function(projeto, escopo, tarefa) {
		if ( tarefa.id !== null ) {
			return $http.put('api/projeto/'+projeto.id+'/escopo/'+escopo.id
				+'/tarefa/'+tarefa.id, tarefa);
		} else {
			return $http.post('api/projeto/'+projeto.id+'/escopo'+escopo.id
				+'/tarefa', tarefa);
		}
	};
	this.getRequisito = function(projeto, escopo, tarefa) {
		return $http.get('api/projeto/'+projeto.id+'/escopo/'+escopo.id
			+'/tarefa/'+tarefa.id);
	};
}).service('AlocacaoService', function($http){
	this.getAlocacoesByProjetoAndEscopo = function(projeto, escopo){
		return $http.get('api/projeto/'+projeto.id+'/escopo/'+escopo.id+'/alocacao');
	};
	this.persist = function(projeto, escopo, alocacao) {
		if ( alocacao.id != null ) {
			return $http.put('api/projeto/'+projeto.id+'/escopo/'+escopo.id
				+'/alocacao/'+alocacao.id, alocacao);
		} else {
			return $http.post('api/projeto/'+projeto.id+'/escopo/'+escopo.id
				+'/alocacao', alocacao);
		}
	};
	this.getAlocacao = function(projeto, escopo, alocacao) {
		return $http.get('api/projeto/'+projeto.id+'/escopo/'+escopo.id
			+'/alocacao/'+alocacao.id);
	};
	this.deleteAlocacao = function(projeto, escopo, alocacao){
		return $http.delete('api/projeto/'+projeto.id+'/escopo/'+escopo.id
			+'/alocacao/'+alocacao.id);
	};
}).directive('menuNavegacao', function($routeParams){
	return {
		scope:true,
		templateUrl:'directive/menu-navegacao.html',
		link:function(scope, element, attrs){
			scope.selected = attrs.menuNavegacao;
			
			scope.idProjeto = $routeParams.idProjeto;
			scope.idEscopo = $routeParams.idEscopo;
			
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
		}, standardErrorHandler);

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
		}, standardErrorHandler);
		
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
			
			var dataAnterior = new Date( $scope.burndown.estimativa[0].finalizacao );
			dataAnterior.setDate( dataAnterior.getDate() - 1 );
			categories.unshift( $filter('date')(dataAnterior, 'dd/MM') );
			
			var tarefasRestantes = $scope.burndown.totalTarefas;
			
			var planejamento = $scope.burndown.planejamento.map(function(element){
				tarefasRestantes -= element.tarefasConcluidas;
				return tarefasRestantes;
			});
			
			planejamento.unshift($scope.burndown.totalTarefas);
			
			var tarefasRestantes = $scope.burndown.totalTarefas;
			
			var realizacao = $scope.burndown.realizacao.map(function(element){
				tarefasRestantes -= element.tarefasConcluidas;
				return tarefasRestantes;
			});
			
			realizacao.unshift($scope.burndown.totalTarefas);
			
			var tarefasRestantes = $scope.burndown.totalTarefas;
			
			var estimativa = $scope.burndown.estimativa.map(function(element){
				tarefasRestantes -= element.tarefasConcluidas;
				return tarefasRestantes;
			});
			
			estimativa.unshift($scope.burndown.totalTarefas);
			
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
			
		}, standardErrorHandler);
	},
	AndamentoController:function($scope, $routeParams, ProjetoService, $window){
		$scope.projeto = {
			id: $routeParams.idProjeto
		};
		
		$scope.escopos = [];
		
		ProjetoService.getAndamento($scope.projeto).then(function(response){
			$scope.escopos = response.data.escopos;
		}, standardErrorHandler);
		
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
			
		}, standardErrorHandler);
	},
	RequisitoController:function($scope, $routeParams, $window, RequisitoService){
		var projeto = {
			id: $routeParams.idProjeto
		};
		var escopo = {
			id: $routeParams.idEscopo
		};
		
		RequisitoService.getRequisitosByProjetoAndEscopo(projeto, escopo).then(function(response){
			$scope.requisitos = response.data;
			console.log($scope.requisitos);
		}, standardErrorHandler);
		
		$scope.classeTipo = function(tipo){
			var defaultClass = 'label-default';
			var tipos = {
				1: 'label-primary',
				2: 'label-warning'
			};
			return tipos[tipo] === undefined ? defaultClass : tipos[tipo];
		};
		$scope.nomeTipo = function(tipo){
			var tipos = {
				1:'Funcional',
				2:'Confiabilidade',
				3:'Usabilidade',
				4:'Desempenho',
				5:'Portabilidade',
				6:'Manutenibilidade',
				7:'Segurança'
			};
			return tipos[tipo];
		};
		
		$scope.removerRequisito = function(requisito){
			if ($window.confirm("Deseja remover o requisito?")) {
				
			}
		};
	},
	TarefaController:function($scope, $routeParams, $window, TarefaService){
		var projeto = {
			id: $routeParams.idProjeto
		};
		var escopo = {
			id: $routeParams.idEscopo
		};
		
		TarefaService.getTarefasByProjetoAndEscopo(projeto, escopo).then(function(response){
			$scope.tarefas = response.data;
			console.log($scope.tarefas);
		}, standardErrorHandler);
		
		$scope.mudarStatus = function(tarefa){
			console.log(tarefa);
			TarefaService.persist(projeto, escopo, tarefa).then(function(response){
				console.log(response);
			}, function( response ){
				standardErrorHandler(response);
				tarefa.status = !tarefa.status;
			});
		};
		$scope.alterarResponsavel = function(tarefa){
			if ($window.confirm("Deseja se tornar responsável pela tarefa?")) {
				
			}
		};
		$scope.editarTarefa = function(tarefa){
			
		};
		$scope.removerTarefa = function(tarefa){
			if ($window.confirm("Deseja remover a tarefa?")) {
				
			}
		};
	},
	AlocacaoController:function($scope, $routeParams, $timeout, AlocacaoService, $window, TarefaService){
		var projeto = {
			id: $routeParams.idProjeto
		};
		var escopo = {
			id: $routeParams.idEscopo
		};
		
		$scope.tipoAlocacao = "planejado"; // realizado
		
		$scope.$watch('tipoAlocacao', function(){
			_renderCalendar();
		});
		
		$scope.alocacoes = [];
		
		var calendario = angular.element('[data-calendar]');
		
		var _filtraTipoSelecionado = function(){
			var tipoSelecionado = $scope.tipoAlocacao==='planejado'? 0 : 1;
			return $scope.alocacoes.filter(function(alocacao){
				return alocacao.tipo === tipoSelecionado;
			});
		};
		var _numeroTipoAlocacao = function(tipo){
			return tipo==='planejado'? 0 : 1;
		};
		
		var _renderCalendar = function(){
			var alocacoes = _filtraTipoSelecionado();
			calendario.fullCalendar('destroy');
			calendario.fullCalendar({
				header: {
					left:'prev,next today',
					right:'month,agendaWeek,agendaDay'
				},
				drop:function(date, ev, element){
					var date = date;
					var endDate = {};
					angular.copy( date, endDate );
					endDate.add('hours', 2);
					
					var alocacao = {
						inicio: date,
						fim: endDate,
						tarefa: element.helper.data('tarefa'),
						tipo: _numeroTipoAlocacao( $scope.tipoAlocacao )
					};
					
					AlocacaoService.persist(projeto, escopo, alocacao).then(function(response){
						var event = {
							start: date.format(),
							end: endDate.format(),
							title: alocacao.tarefa.titulo
						};
						angular.extend(event, alocacao);

						console.log(event);

						calendario.fullCalendar('renderEvent', event, true); // stick? = true
					}, standardErrorHandler);
				},
				scrollTime:'08:00:00',
				lang:'pt-br',
				timezone:'local',
				eventClick:function(alocacao,element){
					if($window.confirm("Deseja remover a tarefa '"
						+alocacao.tarefa.titulo+"' do dia "
						+moment(alocacao.inicio).format('DD/MM')+"?")) {
						$scope.alocacoes.forEach(function(a, i){
							if (a.id === alocacao.id) {
								// TODO enviar delete pro servidor
								$scope.alocacoes.splice(i, 1);
								_renderCalendar();
								return;
							}
						});
					}
				},
				eventDrop:function(alocacao){
					alocacao.inicio = alocacao.start;
					alocacao.fim = alocacao.end;
					
					AlocacaoService.persist(projeto, escopo, alocacao).then(function(response){
						var event = {
							start: alocacao.start,
							end: alocacao.end,
							title: alocacao.tarefa.titulo
						};
						angular.extend(event, alocacao);

						calendario.fullCalendar('renderEvent', event, true);
					}, standardErrorHandler);
				},
				eventResize:function(alocacao){
					alocacao.inicio = alocacao.start;
					alocacao.fim = alocacao.end;
					
					AlocacaoService.persist(projeto, escopo, alocacao).then(function(response){
						var event = {
							start: alocacao.start,
							end: alocacao.end,
							title: alocacao.tarefa.titulo
						};
						angular.extend(event, alocacao);

						calendario.fullCalendar('renderEvent', event, true);
					}, standardErrorHandler);
				},
				selectable: true,
				selectHelper: true,
				defaultView:'agendaWeek',
				editable: true,
				droppable: true,
				start:new Date(),
				weekNumbers:false,
				allDayDefault:false,
				events: alocacoes.map(function(alocacao){
					alocacao.start = moment(alocacao.inicio).format();
					alocacao.end = moment(alocacao.fim).format();
					alocacao.title = alocacao.tarefa.titulo;
					
					return alocacao;
				})
			});
			$('[data-droppable]').droppable();
		};
		
		AlocacaoService.getAlocacoesByProjetoAndEscopo(projeto, escopo).then(function(response){
			$scope.alocacoes = response.data;
			
			_renderCalendar();
		}, standardErrorHandler);
		
		TarefaService.getTarefasByProjetoAndEscopo(projeto, escopo).then(function(response){
			$scope.tarefas = response.data;

			$timeout(function(){
				angular.element('[data-draggable]').draggable({
					revert:true,
					helper:'clone',
					zIndex: 999
				});
			});
		}, standardErrorHandler);
	},
	ObjetivoController:function($scope, $routeParams, $window, ObjetivoService){
		$scope.idProjeto = $routeParams.idProjeto;
		$scope.idEscopo = $routeParams.idEscopo;
		
		ObjetivoService.getObjetivosByProjeto({id: $scope.idProjeto}).then(function(response){
			$scope.objetivos = response.data;
			console.log(response);
		}, standardErrorHandler);
		
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