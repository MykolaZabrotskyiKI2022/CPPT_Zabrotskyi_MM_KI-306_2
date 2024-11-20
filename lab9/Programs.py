class Programs:
    def __init__(self):
        self.installed_programs = []

    def install(self, program_name):
        self.installed_programs.append(program_name)
        return f"{program_name} installed."

    def list_programs(self):
        return ", ".join(self.installed_programs) if self.installed_programs else "No programs installed."
