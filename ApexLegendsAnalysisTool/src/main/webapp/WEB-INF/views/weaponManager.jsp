<!DOCTYPE html>
<html>
<jsp:include page="includes/header.jsp"></jsp:include>
<body ng-app="weaponManagerApp" ng-controller="WeaponController as ctrl">
	<div>
		<form class="loginform" style="position: fixed;"
			ng-submit="ctrl.submit()" name="weaponForm">
			<input type="hidden" ng-model="ctrl.weapon.id" />
			<div class="loginformcontainer">
				<p class="formtitle">Weapon Editor ${user.username}</p>
				<table>
					<tr>
						<td><input class="input-dark" type="text"
							ng-model="ctrl.weapon.name" name="name"
							placeholder="Weapon Name" required ng-minlength="3" /></td>
					</tr>
					<tr>
						<td><select class="selectcompare" name="type" ng-model="ctrl.weapon.type">
								<option value="" selected disabled hidden>Weapon Type</option>
								<option value="assault rifle">Assault Rifle</option>
								<option value="light machine gun">Light Machine Gun</option>
								<option value="pistol">Pistol</option>
								<option value="shotgun">Shotgun</option>
								<option value="sub machine gun">Sub Machine Gun</option>
								<option value="sniper">Sniper</option>
						</select></td>
					</tr>
					<tr>
						<td><input class="input-dark" type="number"
							ng-model="ctrl.weapon.lowDPS" name="low"
							placeholder="Low DPS" required /></td>
					</tr>
					<tr>
						<td><input class="input-dark" type="number"
							ng-model="ctrl.weapon.highDPS" name="high"
							placeholder="High DPS" required /></td>
					</tr>
					<tr>
					<td><input class="darkbtn" type="submit"
						value="{{!ctrl.weapon.id ? 'Add' : 'Update'}}" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div>
		<table class="selector white lefttable">
			<thead>
				<tr>
					<th>Icon</th>
					<th>Name</th>
					<th>Type</th>
					<th>Low DPS</th>
					<th>High DPS</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="weapon in ctrl.weapons">
					<td align="center"><img height="100px" width="200px"
						ng-src="{{weapon.imageSource}}"></td>
					<td align="center"><span ng-bind="weapon.name"></span></td>
					<td align="center"><span ng-bind="weapon.type"></span></td>
					<td align="center"><span ng-bind="weapon.lowDPS"></span></td>
					<td align="center"><span ng-bind="weapon.highDPS"></span></td>
					<td align="center">
						<button type="button" ng-click="ctrl.edit(weapon.id)"
							class="darkbtn">Edit</button>
						<button type="button" ng-click="ctrl.remove(weapon.id)"
							class="darkbtn">Remove</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script
		src="/ApexLegendsAnalysisTool/static/js/weaponmanager/weaponmanager.app.js"></script>
	<script
		src="/ApexLegendsAnalysisTool/static/js/weaponmanager/weaponmanager.service.js"></script>
	<script
		src="/ApexLegendsAnalysisTool/static/js/weaponmanager/weaponmanager.controller.js"></script>
</body>
</html>