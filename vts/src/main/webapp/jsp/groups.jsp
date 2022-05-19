<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<!-- Styles -->
		<style>
		#chartdiv {
		  width: 100%;
		  height: 500px;
		}
		</style>
		
		<!-- Resources -->
		<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
		<script src="layui/layui.js"></script>
		<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
		<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
		
		<!-- Chart code -->
		<script>
		am5.ready(function() {
		
		// Create root element
		// https://www.amcharts.com/docs/v5/getting-started/#Root_element
		var root = am5.Root.new("chartdiv");
		
		
		// Set themes
		// https://www.amcharts.com/docs/v5/concepts/themes/
		root.setThemes([
		  am5themes_Animated.new(root)
		]);
		
		
		// Create chart
		// https://www.amcharts.com/docs/v5/charts/xy-chart/
		var chart = root.container.children.push(am5xy.XYChart.new(root, {
		  panX: false,
		  panY: false,
		  wheelX: "panX",
		  wheelY: "zoomX",
		  layout: root.verticalLayout
		}));
		
		
		// Add legend
		// https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
		var legend = chart.children.push(
		  am5.Legend.new(root, {
		    centerX: am5.p50,
		    x: am5.p50
		  })
		);
		
		var data = ${groups}
		
		
		// Create axes
		// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
		var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
		  categoryField: "round",
		  renderer: am5xy.AxisRendererX.new(root, {
		    cellStartLocation: 0.1,
		    cellEndLocation: 0.9
		  }),
		  tooltip: am5.Tooltip.new(root, {})
		}));
		
		xAxis.data.setAll(data);
		
		var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
		  renderer: am5xy.AxisRendererY.new(root, {})
		}));
		
		
		// Add series
		// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
		function makeSeries(name, fieldName) {
		  var series = chart.series.push(am5xy.ColumnSeries.new(root, {
		    name: name,
		    xAxis: xAxis,
		    yAxis: yAxis,
		    valueYField: fieldName,
		    categoryXField: "round"
		  }));
		
		  series.columns.template.setAll({
		    tooltipText: "{name}, {categoryX}:{valueY}",
		    width: am5.percent(90),
		    tooltipY: 0
		  });
		
		  series.data.setAll(data);
		
		  // Make stuff animate on load
		  // https://www.amcharts.com/docs/v5/concepts/animations/
		  series.appear();
		
		  series.bullets.push(function () {
		    return am5.Bullet.new(root, {
		      locationY: 0,
		      sprite: am5.Label.new(root, {
		        text: "{valueY}",
		        fill: root.interfaceColors.get("alternativeText"),
		        centerY: 0,
		        centerX: am5.p50,
		        populateText: true
		      })
		    });
		  });
		
		  legend.data.push(series);
		}
		
		//初始化获胜队伍三场成绩
		
		
	

					makeSeries("${person1}", "person1");
					makeSeries("${person2}", "person2");
					makeSeries("${person3}", "person3");
					makeSeries("${person4}", "person4");
					makeSeries("${person5}", "person5");
					makeSeries("${person6}", "person6");
	
		
		
		
		
		
		
		// Make stuff animate on load
		// https://www.amcharts.com/docs/v5/concepts/animations/
		chart.appear(1000, 100);
		
		}); // end am5.ready()
		</script>
	</head>
	<body>
		<!-- HTML -->
		<div id="chartdiv"></div>
	</body>
</html>