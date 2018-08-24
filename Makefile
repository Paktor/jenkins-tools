build-base:
	docker build -t jenkinstools/base:latest -f base/Dockerfile .

base-run:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/base:latest docker ps

build-eb:
	docker build -t jenkinstools/eb:latest -f eb/Dockerfile .

eb-version:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/eb:latest eb --version

build-ecs-cli:
	docker build -t jenkinstools/ecs-cli:latest -f ecs-cli/Dockerfile .

ecs-cli-version:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/ecs-cli:latest ecs-cli --version

build-packer:
	docker build -t jenkinstools/packer:latest -f packer/Dockerfile .

packer-version:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/packer:latest packer --version

make-all: build-base build-eb build-ecs-cli build-packer

