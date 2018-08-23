build:
	docker build -t jenkinstools/ecs-cli:latest .

push:
	docker push jenkinstools/ecs-cli:latest

version:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/ecs-cli:latest ecs-cli --version
